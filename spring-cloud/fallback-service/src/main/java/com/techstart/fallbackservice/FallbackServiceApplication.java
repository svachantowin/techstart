package com.techstart.fallbackservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@RestController
@RequestMapping("/fallbackservice")
public class FallbackServiceApplication {

	@Value("${server.port}")
	private String port;

	public static void main(String[] args) {
		SpringApplication.run(FallbackServiceApplication.class, args);
	}

	@GetMapping
	public String defaultPage(){
		return "You reached fallback service";
	}

	@GetMapping("/info")
	@HystrixCommand(fallbackMethod = "fallbackMethod")
	public String info(){

		throw new RuntimeException();

//		return "Fallback-service is running in port:"+this.port;
	}

	public String fallbackMethod(){
		return "Information failed and fall back method called";
	}



}
