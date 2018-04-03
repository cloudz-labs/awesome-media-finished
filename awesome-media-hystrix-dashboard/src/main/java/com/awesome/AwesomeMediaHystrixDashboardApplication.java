package com.awesome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class AwesomeMediaHystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwesomeMediaHystrixDashboardApplication.class, args);
	}
}