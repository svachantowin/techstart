package com.techstart.rabbitmq.CloudQ.service;

import org.springframework.stereotype.Service;

@Service
public class DataHandler {

    public void processCmd(String data){
        System.out.println("Processing command :"+data);
    }
}
