package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo", "com.weather"})
public class WeatherBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherBackendApplication.class, args);
    }
}
