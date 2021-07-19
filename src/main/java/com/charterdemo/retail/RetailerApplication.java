package com.charterdemo.retail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.core.io.ClassPathResource;

@SpringBootApplication(scanBasePackages = { "com.charterdemo"})
public class RetailerApplication {

	public static void main(String[] args) {
	    SpringApplication.run(RetailerApplication.class, args);
	}

}
