package com.ramdomuser.demo;

import com.ramdomuser.demo.controller.RandomUserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@ComponentScan (basePackages={"com.randomuser.demo"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
