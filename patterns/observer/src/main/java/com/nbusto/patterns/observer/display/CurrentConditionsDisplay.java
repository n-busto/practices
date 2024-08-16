package com.nbusto.patterns.observer.display;

import com.nbusto.patterns.observer.observer.Observer;
import com.nbusto.patterns.observer.subject.WeatherData;

public class CurrentConditionsDisplay implements Observer<WeatherData>, DisplayElement {
    private Float temperature;
    private Float humidity;
    private Float pressure;
    private WeatherData weatherData;

    @Override
    public String display() {
        return "Current conditions:\n" +
                "Temperature: %s U00B0C%n".formatted(temperature) +
                "Humidity: %s %%%n".formatted(humidity) +
                "Pressure: %s bar%n".formatted(pressure);
    }

    @Override
    public void update() {
        temperature = weatherData.getTemperature();
        humidity = weatherData.getHumidity();
        pressure = weatherData.getPressure();
    }

    @Override
    public void setSubject(WeatherData subject) {
        this.weatherData = subject;
    }
}
