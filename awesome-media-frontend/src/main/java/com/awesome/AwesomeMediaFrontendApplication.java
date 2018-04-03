package com.awesome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class AwesomeMediaFrontendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwesomeMediaFrontendApplication.class, args);
	}
}
