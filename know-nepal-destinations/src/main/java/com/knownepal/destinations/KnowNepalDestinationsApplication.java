package com.knownepal.destinations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class KnowNepalDestinationsApplication {

    public static void main(String[] args) {
        SpringApplication.run(KnowNepalDestinationsApplication.class, args);
    }
}
