package com.weather.controller;

import com.weather.service.WeatherService;
import com.weather.model.WeatherResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{city}")
    public ResponseEntity<?> getWeather(@PathVariable String city) {
        WeatherResponse weatherResponse = weatherService.getWeather(city);
        if (weatherResponse == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Weather data for city '" + city + "' not found or unable to fetch.");
        }
        return ResponseEntity.ok(weatherResponse);
    }
}
