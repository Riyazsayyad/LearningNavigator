package com.learningnavigator.learningnavigator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.learningnavigator.learningnavigator.repository")
@EntityScan("com.learningnavigator.learningnavigator.entity")

public class LearningnavigatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningnavigatorApplication.class, args);
	}

}
