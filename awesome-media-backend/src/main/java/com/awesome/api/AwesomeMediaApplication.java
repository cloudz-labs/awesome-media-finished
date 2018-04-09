package com.awesome.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AwesomeMediaApplication {
	
	@RequestMapping("/")
	public String home() {
		return "Awesome Movie Backend API Service 1.0"; 
	}

	public static void main(String[] args) {
		SpringApplication.run(AwesomeMediaApplication.class, args);
	}

}