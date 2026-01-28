package com.gym.GestorGym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class GestorGymApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestorGymApplication.class, args);
	}

}
