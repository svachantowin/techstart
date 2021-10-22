package com.techstart.rabbitmq.CloudQ.processor;

import com.techstart.rabbitmq.CloudQ.service.DataSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SendingComponent {

    @Autowired
    private DataSender dataSender;

//    @Scheduled(cron="${runtime.periodicSend.cronExpression}")
    @Scheduled(fixedRate = 5000)
    public void periodicSendData(){
        dataSender.sendData("Sending something");
    }

}
