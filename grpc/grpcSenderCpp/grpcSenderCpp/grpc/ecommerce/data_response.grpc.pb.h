// Generated by the gRPC C++ plugin.
// If you make any local change, they will be lost.
// source: ecommerce/data_response.proto
#ifndef GRPC_ecommerce_2fdata_5fresponse_2eproto__INCLUDED
#define GRPC_ecommerce_2fdata_5fresponse_2eproto__INCLUDED

#include "ecommerce/data_response.pb.h"

#include <functional>
#include <grpc/impl/codegen/port_platform.h>
#include <grpcpp/impl/codegen/async_generic_service.h>
#include <grpcpp/impl/codegen/async_stream.h>
#include <grpcpp/impl/codegen/async_unary_call.h>
#include <grpcpp/impl/codegen/client_callback.h>
#include <grpcpp/impl/codegen/client_context.h>
#include <grpcpp/impl/codegen/completion_queue.h>
#include <grpcpp/impl/codegen/message_allocator.h>
#include <grpcpp/impl/codegen/method_handler.h>
#include <grpcpp/impl/codegen/proto_utils.h>
#include <grpcpp/impl/codegen/rpc_method.h>
#include <grpcpp/impl/codegen/server_callback.h>
#include <grpcpp/impl/codegen/server_callback_handlers.h>
#include <grpcpp/impl/codegen/server_context.h>
#include <grpcpp/impl/codegen/service_type.h>
#include <grpcpp/impl/codegen/status.h>
#include <grpcpp/impl/codegen/stub_options.h>
#include <grpcpp/impl/codegen/sync_stream.h>

namespace ecommerce {

class DataService final {
 public:
  static constexpr char const* service_full_name() {
    return "ecommerce.DataService";
  }
  class StubInterface {
   public:
    virtual ~StubInterface() {}
    std::unique_ptr< ::grpc::ClientReaderInterface< ::ecommerce::DataResponse>> getData(::grpc::ClientContext* context, const ::ecommerce::DataRequest& request) {
      return std::unique_ptr< ::grpc::ClientReaderInterface< ::ecommerce::DataResponse>>(getDataRaw(context, request));
    }
    std::unique_ptr< ::grpc::ClientAsyncReaderInterface< ::ecommerce::DataResponse>> AsyncgetData(::grpc::ClientContext* context, const ::ecommerce::DataRequest& request, ::grpc::CompletionQueue* cq, void* tag) {
      return std::unique_ptr< ::grpc::ClientAsyncReaderInterface< ::ecommerce::DataResponse>>(AsyncgetDataRaw(context, request, cq, tag));
    }
    std::unique_ptr< ::grpc::ClientAsyncReaderInterface< ::ecommerce::DataResponse>> PrepareAsyncgetData(::grpc::ClientContext* context, const ::ecommerce::DataRequest& request, ::grpc::CompletionQueue* cq) {
      return std::unique_ptr< ::grpc::ClientAsyncReaderInterface< ::ecommerce::DataResponse>>(PrepareAsyncgetDataRaw(context, request, cq));
    }
    class experimental_async_interface {
     public:
      virtual ~experimental_async_interface() {}
      #ifdef GRPC_CALLBACK_API_NONEXPERIMENTAL
      virtual void getData(::grpc::ClientContext* context, const ::ecommerce::DataRequest* request, ::grpc::ClientReadReactor< ::ecommerce::DataResponse>* reactor) = 0;
      #else
      virtual void getData(::grpc::ClientContext* context, const ::ecommerce::DataRequest* request, ::grpc::experimental::ClientReadReactor< ::ecommerce::DataResponse>* reactor) = 0;
      #endif
    };
    #ifdef GRPC_CALLBACK_API_NONEXPERIMENTAL
    typedef class experimental_async_interface async_interface;
    #endif
    #ifdef GRPC_CALLBACK_API_NONEXPERIMENTAL
    async_interface* async() { return experimental_async(); }
    #endif
    virtual class experimental_async_interface* experimental_async() { return nullptr; }
  private:
    virtual ::grpc::ClientReaderInterface< ::ecommerce::DataResponse>* getDataRaw(::grpc::ClientContext* context, const ::ecommerce::DataRequest& request) = 0;
    virtual ::grpc::ClientAsyncReaderInterface< ::ecommerce::DataResponse>* AsyncgetDataRaw(::grpc::ClientContext* context, const ::ecommerce::DataRequest& request, ::grpc::CompletionQueue* cq, void* tag) = 0;
    virtual ::grpc::ClientAsyncReaderInterface< ::ecommerce::DataResponse>* PrepareAsyncgetDataRaw(::grpc::ClientContext* context, const ::ecommerce::DataRequest& request, ::grpc::CompletionQueue* cq) = 0;
  };
  class Stub final : public StubInterface {
   public:
    Stub(const std::shared_ptr< ::grpc::ChannelInterface>& channel);
    std::unique_ptr< ::grpc::ClientReader< ::ecommerce::DataResponse>> getData(::grpc::ClientContext* context, const ::ecommerce::DataRequest& request) {
      return std::unique_ptr< ::grpc::ClientReader< ::ecommerce::DataResponse>>(getDataRaw(context, request));
    }
    std::unique_ptr< ::grpc::ClientAsyncReader< ::ecommerce::DataResponse>> AsyncgetData(::grpc::ClientContext* context, const ::ecommerce::DataRequest& request, ::grpc::CompletionQueue* cq, void* tag) {
      return std::unique_ptr< ::grpc::ClientAsyncReader< ::ecommerce::DataResponse>>(AsyncgetDataRaw(context, request, cq, tag));
    }
    std::unique_ptr< ::grpc::ClientAsyncReader< ::ecommerce::DataResponse>> PrepareAsyncgetData(::grpc::ClientContext* context, const ::ecommerce::DataRequest& request, ::grpc::CompletionQueue* cq) {
      return std::unique_ptr< ::grpc::ClientAsyncReader< ::ecommerce::DataResponse>>(PrepareAsyncgetDataRaw(context, request, cq));
    }
    class experimental_async final :
      public StubInterface::experimental_async_interface {
     public:
      #ifdef GRPC_CALLBACK_API_NONEXPERIMENTAL
      void getData(::grpc::ClientContext* context, const ::ecommerce::DataRequest* request, ::grpc::ClientReadReactor< ::ecommerce::DataResponse>* reactor) override;
      #else
      void getData(::grpc::ClientContext* context, const ::ecommerce::DataRequest* request, ::grpc::experimental::ClientReadReactor< ::ecommerce::DataResponse>* reactor) override;
      #endif
     private:
      friend class Stub;
      explicit experimental_async(Stub* stub): stub_(stub) { }
      Stub* stub() { return stub_; }
      Stub* stub_;
    };
    class experimental_async_interface* experimental_async() override { return &async_stub_; }

   private:
    std::shared_ptr< ::grpc::ChannelInterface> channel_;
    class experimental_async async_stub_{this};
    ::grpc::ClientReader< ::ecommerce::DataResponse>* getDataRaw(::grpc::ClientContext* context, const ::ecommerce::DataRequest& request) override;
    ::grpc::ClientAsyncReader< ::ecommerce::DataResponse>* AsyncgetDataRaw(::grpc::ClientContext* context, const ::ecommerce::DataRequest& request, ::grpc::CompletionQueue* cq, void* tag) override;
    ::grpc::ClientAsyncReader< ::ecommerce::DataResponse>* PrepareAsyncgetDataRaw(::grpc::ClientContext* context, const ::ecommerce::DataRequest& request, ::grpc::CompletionQueue* cq) override;
    const ::grpc::internal::RpcMethod rpcmethod_getData_;
  };
  static std::unique_ptr<Stub> NewStub(const std::shared_ptr< ::grpc::ChannelInterface>& channel, const ::grpc::StubOptions& options = ::grpc::StubOptions());

  class Service : public ::grpc::Service {
   public:
    Service();
    virtual ~Service();
    virtual ::grpc::Status getData(::grpc::ServerContext* context, const ::ecommerce::DataRequest* request, ::grpc::ServerWriter< ::ecommerce::DataResponse>* writer);
  };
  template <class BaseClass>
  class WithAsyncMethod_getData : public BaseClass {
   private:
    void BaseClassMustBeDerivedFromService(const Service* /*service*/) {}
   public:
    WithAsyncMethod_getData() {
      ::grpc::Service::MarkMethodAsync(0);
    }
    ~WithAsyncMethod_getData() override {
      BaseClassMustBeDerivedFromService(this);
    }
    // disable synchronous version of this method
    ::grpc::Status getData(::grpc::ServerContext* /*context*/, const ::ecommerce::DataRequest* /*request*/, ::grpc::ServerWriter< ::ecommerce::DataResponse>* /*writer*/) override {
      abort();
      return ::grpc::Status(::grpc::StatusCode::UNIMPLEMENTED, "");
    }
    void RequestgetData(::grpc::ServerContext* context, ::ecommerce::DataRequest* request, ::grpc::ServerAsyncWriter< ::ecommerce::DataResponse>* writer, ::grpc::CompletionQueue* new_call_cq, ::grpc::ServerCompletionQueue* notification_cq, void *tag) {
      ::grpc::Service::RequestAsyncServerStreaming(0, context, request, writer, new_call_cq, notification_cq, tag);
    }
  };
  typedef WithAsyncMethod_getData<Service > AsyncService;
  template <class BaseClass>
  class ExperimentalWithCallbackMethod_getData : public BaseClass {
   private:
    void BaseClassMustBeDerivedFromService(const Service* /*service*/) {}
   public:
    ExperimentalWithCallbackMethod_getData() {
    #ifdef GRPC_CALLBACK_API_NONEXPERIMENTAL
      ::grpc::Service::
    #else
      ::grpc::Service::experimental().
    #endif
        MarkMethodCallback(0,
          new ::grpc::internal::CallbackServerStreamingHandler< ::ecommerce::DataRequest, ::ecommerce::DataResponse>(
            [this](
    #ifdef GRPC_CALLBACK_API_NONEXPERIMENTAL
                   ::grpc::CallbackServerContext*
    #else
                   ::grpc::experimental::CallbackServerContext*
    #endif
                     context, const ::ecommerce::DataRequest* request) { return this->getData(context, request); }));
    }
    ~ExperimentalWithCallbackMethod_getData() override {
      BaseClassMustBeDerivedFromService(this);
    }
    // disable synchronous version of this method
    ::grpc::Status getData(::grpc::ServerContext* /*context*/, const ::ecommerce::DataRequest* /*request*/, ::grpc::ServerWriter< ::ecommerce::DataResponse>* /*writer*/) override {
      abort();
      return ::grpc::Status(::grpc::StatusCode::UNIMPLEMENTED, "");
    }
    #ifdef GRPC_CALLBACK_API_NONEXPERIMENTAL
    virtual ::grpc::ServerWriteReactor< ::ecommerce::DataResponse>* getData(
      ::grpc::CallbackServerContext* /*context*/, const ::ecommerce::DataRequest* /*request*/)
    #else
    virtual ::grpc::experimental::ServerWriteReactor< ::ecommerce::DataResponse>* getData(
      ::grpc::experimental::CallbackServerContext* /*context*/, const ::ecommerce::DataRequest* /*request*/)
    #endif
      { return nullptr; }
  };
  #ifdef GRPC_CALLBACK_API_NONEXPERIMENTAL
  typedef ExperimentalWithCallbackMethod_getData<Service > CallbackService;
  #endif

  typedef ExperimentalWithCallbackMethod_getData<Service > ExperimentalCallbackService;
  template <class BaseClass>
  class WithGenericMethod_getData : public BaseClass {
   private:
    void BaseClassMustBeDerivedFromService(const Service* /*service*/) {}
   public:
    WithGenericMethod_getData() {
      ::grpc::Service::MarkMethodGeneric(0);
    }
    ~WithGenericMethod_getData() override {
      BaseClassMustBeDerivedFromService(this);
    }
    // disable synchronous version of this method
    ::grpc::Status getData(::grpc::ServerContext* /*context*/, const ::ecommerce::DataRequest* /*request*/, ::grpc::ServerWriter< ::ecommerce::DataResponse>* /*writer*/) override {
      abort();
      return ::grpc::Status(::grpc::StatusCode::UNIMPLEMENTED, "");
    }
  };
  template <class BaseClass>
  class WithRawMethod_getData : public BaseClass {
   private:
    void BaseClassMustBeDerivedFromService(const Service* /*service*/) {}
   public:
    WithRawMethod_getData() {
      ::grpc::Service::MarkMethodRaw(0);
    }
    ~WithRawMethod_getData() override {
      BaseClassMustBeDerivedFromService(this);
    }
    // disable synchronous version of this method
    ::grpc::Status getData(::grpc::ServerContext* /*context*/, const ::ecommerce::DataRequest* /*request*/, ::grpc::ServerWriter< ::ecommerce::DataResponse>* /*writer*/) override {
      abort();
      return ::grpc::Status(::grpc::StatusCode::UNIMPLEMENTED, "");
    }
    void RequestgetData(::grpc::ServerContext* context, ::grpc::ByteBuffer* request, ::grpc::ServerAsyncWriter< ::grpc::ByteBuffer>* writer, ::grpc::CompletionQueue* new_call_cq, ::grpc::ServerCompletionQueue* notification_cq, void *tag) {
      ::grpc::Service::RequestAsyncServerStreaming(0, context, request, writer, new_call_cq, notification_cq, tag);
    }
  };
  template <class BaseClass>
  class ExperimentalWithRawCallbackMethod_getData : public BaseClass {
   private:
    void BaseClassMustBeDerivedFromService(const Service* /*service*/) {}
   public:
    ExperimentalWithRawCallbackMethod_getData() {
    #ifdef GRPC_CALLBACK_API_NONEXPERIMENTAL
      ::grpc::Service::
    #else
      ::grpc::Service::experimental().
    #endif
        MarkMethodRawCallback(0,
          new ::grpc::internal::CallbackServerStreamingHandler< ::grpc::ByteBuffer, ::grpc::ByteBuffer>(
            [this](
    #ifdef GRPC_CALLBACK_API_NONEXPERIMENTAL
                   ::grpc::CallbackServerContext*
    #else
                   ::grpc::experimental::CallbackServerContext*
    #endif
                     context, const::grpc::ByteBuffer* request) { return this->getData(context, request); }));
    }
    ~ExperimentalWithRawCallbackMethod_getData() override {
      BaseClassMustBeDerivedFromService(this);
    }
    // disable synchronous version of this method
    ::grpc::Status getData(::grpc::ServerContext* /*context*/, const ::ecommerce::DataRequest* /*request*/, ::grpc::ServerWriter< ::ecommerce::DataResponse>* /*writer*/) override {
      abort();
      return ::grpc::Status(::grpc::StatusCode::UNIMPLEMENTED, "");
    }
    #ifdef GRPC_CALLBACK_API_NONEXPERIMENTAL
    virtual ::grpc::ServerWriteReactor< ::grpc::ByteBuffer>* getData(
      ::grpc::CallbackServerContext* /*context*/, const ::grpc::ByteBuffer* /*request*/)
    #else
    virtual ::grpc::experimental::ServerWriteReactor< ::grpc::ByteBuffer>* getData(
      ::grpc::experimental::CallbackServerContext* /*context*/, const ::grpc::ByteBuffer* /*request*/)
    #endif
      { return nullptr; }
  };
  typedef Service StreamedUnaryService;
  template <class BaseClass>
  class WithSplitStreamingMethod_getData : public BaseClass {
   private:
    void BaseClassMustBeDerivedFromService(const Service* /*service*/) {}
   public:
    WithSplitStreamingMethod_getData() {
      ::grpc::Service::MarkMethodStreamed(0,
        new ::grpc::internal::SplitServerStreamingHandler<
          ::ecommerce::DataRequest, ::ecommerce::DataResponse>(
            [this](::grpc::ServerContext* context,
                   ::grpc::ServerSplitStreamer<
                     ::ecommerce::DataRequest, ::ecommerce::DataResponse>* streamer) {
                       return this->StreamedgetData(context,
                         streamer);
                  }));
    }
    ~WithSplitStreamingMethod_getData() override {
      BaseClassMustBeDerivedFromService(this);
    }
    // disable regular version of this method
    ::grpc::Status getData(::grpc::ServerContext* /*context*/, const ::ecommerce::DataRequest* /*request*/, ::grpc::ServerWriter< ::ecommerce::DataResponse>* /*writer*/) override {
      abort();
      return ::grpc::Status(::grpc::StatusCode::UNIMPLEMENTED, "");
    }
    // replace default version of method with split streamed
    virtual ::grpc::Status StreamedgetData(::grpc::ServerContext* context, ::grpc::ServerSplitStreamer< ::ecommerce::DataRequest,::ecommerce::DataResponse>* server_split_streamer) = 0;
  };
  typedef WithSplitStreamingMethod_getData<Service > SplitStreamedService;
  typedef WithSplitStreamingMethod_getData<Service > StreamedService;
};

}  // namespace ecommerce


#endif  // GRPC_ecommerce_2fdata_5fresponse_2eproto__INCLUDED
