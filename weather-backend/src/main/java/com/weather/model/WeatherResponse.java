package com.weather.model;

public class WeatherResponse {
    private String city;
    private double temperatureC;
    private double temperatureF;
    private String description;
    private String icon;

    // No-argument constructor
    public WeatherResponse() {}

    // All-argument constructor
    public WeatherResponse(String city, double temperatureC, double temperatureF, String description, String icon) {
        this.city = city;
        this.temperatureC = temperatureC;
        this.temperatureF = temperatureF;
        this.description = description;
        this.icon = icon;
    }

    // Getters and Setters
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getTemperatureC() {
        return temperatureC;
    }

    public void setTemperatureC(double temperatureC) {
        this.temperatureC = temperatureC;
    }

    public double getTemperatureF() {
        return temperatureF;
    }

    public void setTemperatureF(double temperatureF) {
        this.temperatureF = temperatureF;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
