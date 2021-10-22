package com.techstart.rabbitmq.CloudQ;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class CloudQApplication {



	public static void main(String[] args) {
		SpringApplication.run(CloudQApplication.class, args);

	}

}
