// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: packet_type.proto

#include "packet_type.pb.h"

#include <algorithm>

#include <google/protobuf/io/coded_stream.h>
#include <google/protobuf/extension_set.h>
#include <google/protobuf/wire_format_lite.h>
#include <google/protobuf/descriptor.h>
#include <google/protobuf/generated_message_reflection.h>
#include <google/protobuf/reflection_ops.h>
#include <google/protobuf/wire_format.h>
// @@protoc_insertion_point(includes)
#include <google/protobuf/port_def.inc>

PROTOBUF_PRAGMA_INIT_SEG
namespace ecommerce {
}  // namespace ecommerce
static constexpr ::PROTOBUF_NAMESPACE_ID::Metadata* file_level_metadata_packet_5ftype_2eproto = nullptr;
static const ::PROTOBUF_NAMESPACE_ID::EnumDescriptor* file_level_enum_descriptors_packet_5ftype_2eproto[1];
static constexpr ::PROTOBUF_NAMESPACE_ID::ServiceDescriptor const** file_level_service_descriptors_packet_5ftype_2eproto = nullptr;
const ::PROTOBUF_NAMESPACE_ID::uint32 TableStruct_packet_5ftype_2eproto::offsets[1] = {};
static constexpr ::PROTOBUF_NAMESPACE_ID::internal::MigrationSchema* schemas = nullptr;
static constexpr ::PROTOBUF_NAMESPACE_ID::Message* const* file_default_instances = nullptr;

const char descriptor_table_protodef_packet_5ftype_2eproto[] PROTOBUF_SECTION_VARIABLE(protodesc_cold) =
  "\n\021packet_type.proto\022\tecommerce*:\n\nPacket"
  "Type\022\017\n\013PACKET_NONE\020\000\022\010\n\004DATA\020\001\022\021\n\rSYSTE"
  "M_STATUS\020\002B$\n com.techstart.protobuf.eco"
  "mmerceP\001b\006proto3"
  ;
static ::PROTOBUF_NAMESPACE_ID::internal::once_flag descriptor_table_packet_5ftype_2eproto_once;
const ::PROTOBUF_NAMESPACE_ID::internal::DescriptorTable descriptor_table_packet_5ftype_2eproto = {
  false, false, 136, descriptor_table_protodef_packet_5ftype_2eproto, "packet_type.proto", 
  &descriptor_table_packet_5ftype_2eproto_once, nullptr, 0, 0,
  schemas, file_default_instances, TableStruct_packet_5ftype_2eproto::offsets,
  file_level_metadata_packet_5ftype_2eproto, file_level_enum_descriptors_packet_5ftype_2eproto, file_level_service_descriptors_packet_5ftype_2eproto,
};
PROTOBUF_ATTRIBUTE_WEAK ::PROTOBUF_NAMESPACE_ID::Metadata
descriptor_table_packet_5ftype_2eproto_metadata_getter(int index) {
  ::PROTOBUF_NAMESPACE_ID::internal::AssignDescriptors(&descriptor_table_packet_5ftype_2eproto);
  return descriptor_table_packet_5ftype_2eproto.file_level_metadata[index];
}

// Force running AddDescriptors() at dynamic initialization time.
PROTOBUF_ATTRIBUTE_INIT_PRIORITY static ::PROTOBUF_NAMESPACE_ID::internal::AddDescriptorsRunner dynamic_init_dummy_packet_5ftype_2eproto(&descriptor_table_packet_5ftype_2eproto);
namespace ecommerce {
const ::PROTOBUF_NAMESPACE_ID::EnumDescriptor* PacketType_descriptor() {
  ::PROTOBUF_NAMESPACE_ID::internal::AssignDescriptors(&descriptor_table_packet_5ftype_2eproto);
  return file_level_enum_descriptors_packet_5ftype_2eproto[0];
}
bool PacketType_IsValid(int value) {
  switch (value) {
    case 0:
    case 1:
    case 2:
      return true;
    default:
      return false;
  }
}


// @@protoc_insertion_point(namespace_scope)
}  // namespace ecommerce
PROTOBUF_NAMESPACE_OPEN
PROTOBUF_NAMESPACE_CLOSE

// @@protoc_insertion_point(global_scope)
#include <google/protobuf/port_undef.inc>