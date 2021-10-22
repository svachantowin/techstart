package com.techstart.rabbitmq.CloudQ.processor;

import com.techstart.rabbitmq.CloudQ.channel.DriverChannel;
import com.techstart.rabbitmq.CloudQ.service.DataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import java.util.Set;

// Define only consumers here
@Service
@EnableBinding(DriverChannel.class)
public class DriverProcessor {

    @Autowired
    private DriverChannel driverChannel;

    @Autowired
    private DataHandler dataHandler;

    @StreamListener(DriverChannel.CONTROL_TO_IO_CONSUME)
    public void controlToIOListner(String data) throws InterruptedException{
        dataHandler.processCmd(data);
    }

}
