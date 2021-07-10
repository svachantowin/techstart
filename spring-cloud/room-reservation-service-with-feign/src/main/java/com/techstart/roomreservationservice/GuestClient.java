package com.techstart.roomreservationservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("guestservices")
public interface GuestClient {

    @GetMapping("/hello")
    public String sayHello();

    @GetMapping("/guests")
    public List<String> getGuests();

    @GetMapping("/guestList")
    public List<String> getGuestLists();
}
