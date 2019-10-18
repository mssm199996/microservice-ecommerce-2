package com.mpayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MpaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(MpaymentApplication.class, args);
	}
}
