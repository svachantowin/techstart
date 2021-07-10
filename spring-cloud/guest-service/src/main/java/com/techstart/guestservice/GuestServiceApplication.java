package com.techstart.guestservice;

//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@SpringBootApplication
@RestController
@EnableDiscoveryClient
//@EnableCircuitBreaker
public class GuestServiceApplication {

	@Value("${server.port}")
	private String port;

	public static void main(String[] args) {
		SpringApplication.run(GuestServiceApplication.class, args);
	}

	@GetMapping("/hello")
	public String sayHello(){
		return "Hello SIva";
	}

	@GetMapping("/guests")
	public List<String> getGuests(){
		return Arrays.asList("Siva","Chandran","Raja","Ravi");
	}

	@GetMapping("/guestList")
	public List<String> getGuestList(){
		return Arrays.asList("GuestList","Siva","Chandran","Raja","Ravi");
	}

	@GetMapping("/info")
//	@HystrixCommand(fallbackMethod = "fallbackMethod")
	public String info(){
		return "This is guest Service running in Port :"+port;
	}

	public String fallbackMethod(){
		return "Guest service fall back response";
	}
}
