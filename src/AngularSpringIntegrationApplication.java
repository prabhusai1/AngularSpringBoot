package com.src;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.src.entitites")
@ComponentScan("com.src.controller")
@ComponentScan("com.src.repository")

@SpringBootApplication(scanBasePackages = { "com.src" })

public class AngularSpringIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngularSpringIntegrationApplication.class, args);
	}

}
