package com.example.tabulasoftunispring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class TabulaSoftuniSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(TabulaSoftuniSpringApplication.class, args);
    }

}
