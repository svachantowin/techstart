package com.techstart.testclient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public List<String> getGuestInfo(){
        String url = "http://guestservices/guestList";
        return restTemplate.getForObject(url,List.class);

    }
}
