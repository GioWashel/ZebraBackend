package com.zebra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication

public class ZebraBackEnd {

	public static void main(String[] args) {
		SpringApplication.run(ZebraBackEnd.class, args);
	}

}
