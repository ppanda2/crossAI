package com.cs401.alpha.crossAI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication//(scanBasePackages = {"com.cs401.alpha" })
//@EnableJpaRepositories("com.cs401.alpha.crossAI")
public class CrossAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrossAiApplication.class, args);
	}

}
