package com.techstart.roomreservationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/room-reservations")
public class RoomController {

    private final RestTemplate restTemplate;

    @Value("${server.port}")
    private String port;

    @Autowired
    public RoomController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public List<String> getLists(){
        List<String> guests  = this.getGuests();
        return  guests;
    }

    public List<String> getGuests() {
        ResponseEntity<List<String>> responseEntity = this.restTemplate
                .exchange("http://GUESTSERVICES/guests", HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<String>>() {
                        });
        return  responseEntity.getBody();
    }

    @GetMapping("/info")
    public String getInstance(){
        return "Instance from prot :"+port;
    }
}
