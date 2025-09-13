package com.weather.service;

import com.weather.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

@Service
public class WeatherService {

    private final String WEATHER_API = "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric";

    // Inject API key from application.properties
    @Value("${weather.api.key}")
    private String apiKey;

    public WeatherResponse getWeather(String city) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format(WEATHER_API, city, apiKey);

        try {
            // Call the external weather API and get JSON response as String
            String result = restTemplate.getForObject(url, String.class);
            JSONObject obj = new JSONObject(result);

            WeatherResponse wr = new WeatherResponse();
            wr.setCity(obj.getString("name"));
            wr.setTemperatureC(obj.getJSONObject("main").getDouble("temp"));
            wr.setTemperatureF(wr.getTemperatureC() * 9 / 5 + 32);
            wr.setDescription(obj.getJSONArray("weather").getJSONObject(0).getString("description"));
            wr.setIcon(obj.getJSONArray("weather").getJSONObject(0).getString("icon"));

            return wr;

        } catch (RestClientException e) {
            // Handle errors with the API call, e.g., invalid city or network error
            System.err.println("Failed to fetch weather data: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.err.println("Error processing weather data: " + e.getMessage());
            return null;
        }
    }
}
