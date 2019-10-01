package com.rebu.delivererServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DelivererServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DelivererServerApplication.class, args);
	}

}
