package com.example.soap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:simple-soap-context.xml")
public class SimpleSoapApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleSoapApplication.class, args);
    }
}