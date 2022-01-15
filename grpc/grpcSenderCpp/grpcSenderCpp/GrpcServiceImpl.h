#pragma once

#include <iostream>
#include <memory>
#include <string>
#include <thread>
#include <vector>
#include <queue>

#include <grpc/support/log.h>
#include <grpcpp/grpcpp.h>
#include <grpcpp/alarm.h>
#include "ecommerce/data_response.grpc.pb.h"


using grpc::Server;
using grpc::ServerAsyncWriter;
using grpc::ServerAsyncResponseWriter;
using grpc::ServerBuilder;
using grpc::ServerCompletionQueue;
using grpc::ServerContext;
using grpc::Status;
using grpc::Alarm;

using namespace ecommerce;
using namespace std;



class GrpcServiceImpl final
{
public:
	GrpcServiceImpl();
	~GrpcServiceImpl();

	void Run();

	void pushDataResponseToQ(DataResponse* resp);

	
private:
	// Class encompasing the state and logic needed to serve a request.
	class CallData {
	public:
		// Take in the "service" instance (in this case representing an asynchronous
		// server) and the completion queue "cq" used for asynchronous communication
		// with the gRPC runtime.
		CallData(DataService::AsyncService* service, ServerCompletionQueue* cq,
			int client_id,GrpcServiceImpl& implObj)
			: service_(service), cq_(cq), responder_(&ctx_), status_(CREATE), 
			client_id_(client_id),
			serviceImpl_(implObj)
		{
			std::cout << "Created CallData " << client_id_ << std::endl;
			// Invoke the serving logic right away.
			Proceed();
		}

		void Proceed();// {
		//	if (status_ == CREATE) {
		//		// Make this instance progress to the PROCESS state.
		//		status_ = PROCESS;

		//		// As part of the initial CREATE state, we *request* that the system
		//		// start processing SayHello requests. In this request, "this" acts are
		//		// the tag uniquely identifying the request (so that different CallData
		//		// instances can serve different requests concurrently), in this case
		//		// the memory address of this CallData instance.
		//		
		//		service_->RequestgetmyData(&ctx_, &request_, &responder_, cq_, cq_,
		//			this);
		//		
		//	}
		//	else if (status_ == PROCESS) {
		//		// Spawn a new CallData instance to serve new clients while we process
		//		// the one for this CallData. The instance will deallocate itself as
		//		// part of its FINISH state.
		//		if (times_ == 0) {
		//			new CallData(service_, cq_, client_id_ + 1,serviceImpl_);
		//			times_++;
		//		}
		//		/*if (times_++ >= 10) {
		//			status_ = FINISH;
		//			responder_.Finish(Status::OK, this);
		//		}
		//		else
		//		{*/
		//			
		//		if (serviceImpl_.hasDataToSend())
		//		{
		//			DataResponse dataResp = serviceImpl_.getPLCRespData();
		//			
		//			responder_.Write(dataResp, this);
		//			
		//			// The actual processing.
		//			/*std::string prefix("Hello ");
		//			DataResponse reply_;
		//			myData *myData = reply_.add_ecommerce_data();
		//			myData->set_item_name("someItem");
		//			myData->set_item_type(ecommerce::SHORT);
		//			myData->set_short_value(20);
		//			responder_.Write(reply_, this);
		//			Sleep(1000);*/
		//		}
		//		else
		//		{
		//			// If there's no data to be written, put the task back into the queue
		//			PutTaskBackToQueue();
		//		}
		//		//}
		//		

		//		

		//		
		//		//reply_.set_message(prefix + request_.name());

		//		// And we are done! Let the gRPC runtime know we've finished, using the
		//		// memory address of this instance as the uniquely identifying tag for
		//		// the event.
		//		//status_ = FINISH;
		//		
		//		
		//		//responder_.Finish(Status::OK, this);
		//		
		//		//responder_.Finish(reply_, Status::OK, this);
		//	}
		//	else {
		//		GPR_ASSERT(status_ == FINISH);
		//		// Once in the FINISH state, deallocate ourselves (CallData).
		//		delete this;
		//	}
		//}
		//bool HasData()
		//{
		//	bool hasDataInQ = false;
		//	if (m_vDataRespQ.size() > 0) {
		//		hasDataInQ = true;
		//	}
		//		
		//	// A dummy condition to make it sometimes have data and sometimes not
		//	return hasDataInQ;
		//}

		void PutTaskBackToQueue();
		/*{
			alarm_.Set(cq_, gpr_now(gpr_clock_type::GPR_CLOCK_REALTIME), this);
		}*/
		void Stop();
		/*{
			std::cerr << "Finishing up client " << client_id_ << std::endl;
			status_ = CallStatus::FINISH;
		}*/

	private:
		// The means of communication with the gRPC runtime for an asynchronous
		// server.
		DataService::AsyncService* service_;
		// The producer-consumer queue where for asynchronous server notifications.
		ServerCompletionQueue* cq_;
		// Context for the rpc, allowing to tweak aspects of it such as the use
		// of compression, authentication, as well as to send metadata back to the
		// client.
		ServerContext ctx_;
		int times_;
		int client_id_;
		Alarm alarm_;
		GrpcServiceImpl& serviceImpl_;
		// What we get from the client.
		DataRequest request_;
		// What we send back to the client.
		/*DataResponse reply_;*/

		// The means to get back to the client.
		ServerAsyncWriter<DataResponse> responder_;

		// Let's implement a tiny state machine with the following states.
		enum CallStatus { CREATE, PROCESS, FINISH };
		CallStatus status_;  // The current serving state.
	};

	vector<DataResponse> getPLCRespFromBuffer();
	DataResponse* getPLCRespData();
	bool hasDataToSend();

	int num_clients_ = 0;
	void HandleRpcs();
	std::unique_ptr<ServerCompletionQueue> cq_;
	DataService::AsyncService service_;
	std::unique_ptr<Server> server_;

	queue<DataResponse*> m_vDataRespQ;
	CRITICAL_SECTION m_csTagRespSection;
};

