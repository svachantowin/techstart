// grpcSenderCpp.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "protobuf/ecommerce/data_response.pb.h"
#include "log4cxx/logger.h"
#include "log4cxx/xml/domconfigurator.h"
#include "GrpcServiceImpl.h"

using namespace log4cxx;
using namespace log4cxx::xml;
using namespace log4cxx::helpers;
using namespace ecommerce;

// Define static logger variable
LoggerPtr logger(Logger::getLogger("grpcTest"));


int main()
{
	printf("Testing GRPC & Protobuf");

	GrpcServiceImpl* service = new GrpcServiceImpl();

	DataResponse *dataResponse = new DataResponse();
	ECommerceData *data = dataResponse->add_ecommerce_data();
	data->set_uniq_id(1);
	data->set_item_type(ecommerce::SHORT_DATA);
	data->set_short_value(100);

	while (true) {
		printf("\n Sending data via GRPC");
		service->pushDataResponseToQ(dataResponse);
		Sleep(3000);
	}
	

    return 0;
}

