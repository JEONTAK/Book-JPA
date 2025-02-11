package com.example.bookjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BookJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookJpaApplication.class, args);
    }

}
