package com.techstart.rabbitmq.CloudQ.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface DriverChannel {
    String CONTROL_TO_IO_CONSUME = "Control-IODriver-ReceiveChannel";

    String IO_HMI_PRODUCE = "IODriver-HMI-PublishChannel";

    @Input(CONTROL_TO_IO_CONSUME)
    SubscribableChannel controlToIoReceive();

    @Output(IO_HMI_PRODUCE)
    MessageChannel ioToHMISend();

}
