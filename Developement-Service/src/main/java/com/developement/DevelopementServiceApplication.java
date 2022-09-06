package com.developement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DevelopementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevelopementServiceApplication.class, args);
	}

}
