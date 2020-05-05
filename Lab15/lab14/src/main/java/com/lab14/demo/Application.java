package com.lab14.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "edu.miu.common, com.lab14.demo")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
