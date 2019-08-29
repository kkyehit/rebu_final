package com.rebu.memberServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class MemberServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemberServerApplication.class, args);
	}

}
