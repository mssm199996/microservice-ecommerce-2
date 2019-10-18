package com.mssmfactory.cloudserverconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class CloudServerConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudServerConfigApplication.class, args);
	}
}
