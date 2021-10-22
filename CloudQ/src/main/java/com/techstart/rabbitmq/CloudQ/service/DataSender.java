package com.techstart.rabbitmq.CloudQ.service;

import com.techstart.rabbitmq.CloudQ.channel.DriverChannel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.integration.support.MessageBuilder;

@Service
public class DataSender {

    @Autowired
    private DriverChannel channel;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void sendData(String data){
//        System.out.println("Sending data :"+data);
        logger.info("Sending data :"+data);
        channel.ioToHMISend().send(MessageBuilder.withPayload(data).setHeader("routeTo","com.techstart.data").build());
    }
}
