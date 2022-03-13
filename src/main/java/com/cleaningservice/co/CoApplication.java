package com.cleaningservice.co;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableWebMvc
//@EnableScheduling
@SpringBootApplication
public class CoApplication {

	public static void main(String[] args) {

		SpringApplication.run(CoApplication.class, args);
	}

}
