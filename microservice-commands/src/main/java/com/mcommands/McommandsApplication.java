package com.mcommands;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class McommandsApplication {

	public static void main(String[] args) {
		SpringApplication.run(McommandsApplication.class, args);
	}
}
