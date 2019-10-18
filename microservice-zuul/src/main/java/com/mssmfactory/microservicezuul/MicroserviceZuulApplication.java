package com.mssmfactory.microservicezuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class MicroserviceZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceZuulApplication.class, args);
	}
}
