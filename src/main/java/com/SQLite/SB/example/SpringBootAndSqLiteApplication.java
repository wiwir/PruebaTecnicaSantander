package com.SQLite.SB.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootAndSqLiteApplication {

	public static void main(String[] args) {

		Class<?>[] configClasses = {SpringBootAndSqLiteApplication.class, SwaggerConfig.class};
		SpringApplication.run(configClasses, args);
	}

}
