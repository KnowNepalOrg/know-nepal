package com.knownepal.geography;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableCaching
public class KnowNepalGeographyApplication {

	public static void main(String[] args) {
		SpringApplication.run(KnowNepalGeographyApplication.class, args);
	}

}
