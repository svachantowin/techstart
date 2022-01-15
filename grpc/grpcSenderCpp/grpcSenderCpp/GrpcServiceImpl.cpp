#include "GrpcServiceImpl.h"
#include "log4cxx/logger.h"
using namespace log4cxx;
using namespace log4cxx::helpers;
extern LoggerPtr logger;


GrpcServiceImpl::GrpcServiceImpl()
{
	InitializeCriticalSection(&m_csTagRespSection);
}


GrpcServiceImpl::~GrpcServiceImpl()
{
	server_->Shutdown();
	// Always shutdown the completion queue after the server.
	cq_->Shutdown();
	DeleteCriticalSection(&m_csTagRespSection);
}

void  GrpcServiceImpl::Run() {

	std::string server_address("0.0.0.0:50051");

	ServerBuilder builder;
	// Listen on the given address without any authentication mechanism.
	builder.AddListeningPort(server_address, grpc::InsecureServerCredentials());
	// Register "service_" as the instance through which we'll communicate with
	// clients. In this case it corresponds to an *asynchronous* service.
	builder.RegisterService(&service_);
	// Get hold of the completion queue used for the asynchronous communication
	// with the gRPC runtime.
	cq_ = builder.AddCompletionQueue();
	// Finally assemble the server.
	server_ = builder.BuildAndStart();
	std::cout << "Server listening on " << server_address << std::endl;

	// Proceed to the server's main loop.
	HandleRpcs();

}

void GrpcServiceImpl::HandleRpcs() {
	// Spawn a new CallData instance to serve new clients.
	new CallData(&service_, cq_.get(),num_clients_++,*this);
	
	while (true) {
		void* tag=NULL;  // uniquely identifies a request.
		bool ok;
		// Block waiting to read the next event from the completion queue. The
		// event is uniquely identified by its tag, which in this case is the
		// memory address of a CallData instance.
		// The return value of Next should always be checked. This return value
		// tells us whether there is any kind of event or cq_ is shutting down.
		
		cq_->Next(&tag, &ok);
		//GPR_ASSERT(cq_->Next(&tag, &ok));
		//GPR_ASSERT(ok);
		if (!ok)
		{
			static_cast<CallData*>(tag)->Stop();
			continue;
		}
		static_cast<CallData*>(tag)->Proceed();
	}

}

void GrpcServiceImpl::pushDataResponseToQ(DataResponse* response) {

	EnterCriticalSection(&m_csTagRespSection);

	LOG4CXX_DEBUG(logger, "Adding myData data Responce to gRPC buffer");
	m_vDataRespQ.push(response);
	
	//printf("Size of Q : %d", m_vDataRespQ.size());

	LeaveCriticalSection(&m_csTagRespSection);
	LOG4CXX_INFO(logger, "Pushing myDataData . DataQ size [" << m_vDataRespQ.size() << "]");

}

bool GrpcServiceImpl::hasDataToSend() {
	bool hasDataInQ = false;
	if (m_vDataRespQ.size() > 0) {
		hasDataInQ = true;
	}

	return hasDataInQ;
}

vector<DataResponse> GrpcServiceImpl::getPLCRespFromBuffer() {

	vector<DataResponse> vRespList;

	/*if (m_vDataRespQ.size() <= 0) {
		return vRespList;
	}

	EnterCriticalSection(&m_csTagRespSection);

	LOG4CXX_DEBUG(logger, "Reading all Data Response from buffer");

	while (!m_vDataRespQ.empty()) {

		myDataDataResponse dataResp;
		dataResp = m_vDataRespQ.front();
		vRespList.push_back(dataResp);
		m_vDataRespQ.pop();
	}

	LeaveCriticalSection(&m_csTagRespSection);*/

	return vRespList;
}

DataResponse* GrpcServiceImpl::getPLCRespData() {

	DataResponse* dataResp=NULL;

	if (m_vDataRespQ.size() <= 0) {
		return dataResp;
	}

	EnterCriticalSection(&m_csTagRespSection);

	
	dataResp = m_vDataRespQ.front();
	m_vDataRespQ.pop();
	

	LeaveCriticalSection(&m_csTagRespSection);

	return dataResp;
}

void GrpcServiceImpl::CallData::Proceed() {
	if (status_ == CREATE) {
		// Make this instance progress to the PROCESS state.
		status_ = PROCESS;

		// As part of the initial CREATE state, we *request* that the system
		// start processing SayHello requests. In this request, "this" acts are
		// the tag uniquely identifying the request (so that different CallData
		// instances can serve different requests concurrently), in this case
		// the memory address of this CallData instance.

		service_->RequestgetData(&ctx_, &request_, &responder_, cq_, cq_,
			this);

	}
	else if (status_ == PROCESS) {
		// Spawn a new CallData instance to serve new clients while we process
		// the one for this CallData. The instance will deallocate itself as
		// part of its FINISH state.
		if (times_ == 0) {
			new CallData(service_, cq_, client_id_ + 1, serviceImpl_);
			times_++;
		}
		/*if (times_++ >= 10) {
		status_ = FINISH;
		responder_.Finish(Status::OK, this);
		}
		else
		{*/

		if (serviceImpl_.hasDataToSend())
		{
			DataResponse* dataResp = serviceImpl_.getPLCRespData();
			LOG4CXX_INFO(logger, "Before sending");
			responder_.Write(*dataResp, this);
			LOG4CXX_INFO(logger, "Data Sent To serverStream DataCount["<<dataResp->ecommerce_data_size() <<"] QueueSize ["<<serviceImpl_.m_vDataRespQ.size()<<"]");
			delete dataResp;

			// The actual processing.
			/*std::string prefix("Hello ");
			myDataDataResponse reply_;
			myDataData *myDataData = reply_.add_myData_data();
			myDataData->set_item_name("someItem");
			myDataData->set_item_type(myData::SHORT);
			myDataData->set_short_value(20);
			responder_.Write(reply_, this);
			Sleep(1000);*/
		}
		else
		{
			
			LOG4CXX_INFO(logger, "No data to send. Going to wait mode");
			// If there's no data to be written, put the task back into the queue
			PutTaskBackToQueue();
		}
		//}





		//reply_.set_message(prefix + request_.name());

		// And we are done! Let the gRPC runtime know we've finished, using the
		// memory address of this instance as the uniquely identifying tag for
		// the event.
		//status_ = FINISH;


		//responder_.Finish(Status::OK, this);

		//responder_.Finish(reply_, Status::OK, this);
	}
	else {
		GPR_ASSERT(status_ == FINISH);
		// Once in the FINISH state, deallocate ourselves (CallData).
		delete this;
	}
}

void GrpcServiceImpl::CallData::PutTaskBackToQueue() {

	//alarm_.Set(cq_, gpr_now(gpr_clock_type::GPR_CLOCK_REALTIME), this);
	alarm_.Set(cq_, std::chrono::system_clock::now() +std::chrono::milliseconds(2), this);
}

void GrpcServiceImpl::CallData::Stop() {
	std::cerr << "Finishing up client " << client_id_ << std::endl;
	status_ = CallStatus::FINISH;
}