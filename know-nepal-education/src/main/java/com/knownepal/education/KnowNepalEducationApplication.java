package com.knownepal.education;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableCaching
public class KnowNepalEducationApplication {

	public static void main(String[] args) {
		SpringApplication.run(KnowNepalEducationApplication.class, args);
	}
}
