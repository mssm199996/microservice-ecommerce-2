package com.mproducts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MproductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MproductsApplication.class, args);
	}
}
