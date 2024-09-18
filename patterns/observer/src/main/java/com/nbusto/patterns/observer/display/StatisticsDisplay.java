package com.nbusto.patterns.observer.display;

import com.nbusto.patterns.observer.observer.Observer;
import com.nbusto.patterns.observer.subject.WeatherData;

public class StatisticsDisplay implements Observer<WeatherData>, DisplayElement {
  private Float minTemperature;
  private Float minHumidity;
  private Float minPressure;
  private Float maxTemperature;
  private Float maxHumidity;
  private Float maxPressure;
  private WeatherData subject;

  @Override
  public void update() {
    minTemperature = min(subject.getTemperature(), minTemperature);
    minHumidity = min(subject.getHumidity(), minHumidity);
    minPressure = min(subject.getPressure(), minPressure);

    maxTemperature = max(subject.getTemperature(), maxTemperature);
    maxHumidity = max(subject.getHumidity(), maxHumidity);
    maxPressure = max(subject.getPressure(), maxPressure);
  }

  @Override
  public void setSubject(WeatherData subject) {
    this.subject = subject;
  }

  private Float min(Float aFloat, Float anotherFloat) {
    if (someIsNull(aFloat, anotherFloat)) {
      return returnNonNull(aFloat, anotherFloat);
    }

    return Float.min(aFloat, anotherFloat);
  }

  private Float max(Float aFloat, Float anotherFloat) {
    if (someIsNull(aFloat, anotherFloat)) {
      return returnNonNull(aFloat, anotherFloat);
    }

    return Float.max(aFloat, anotherFloat);
  }

  private Float returnNonNull(Float aFloat, Float anotherFloat) {
    return aFloat == null ? anotherFloat : aFloat;
  }

  private boolean someIsNull(Float aFloat, Float anotherFloat) {
    return aFloat == null || anotherFloat == null;
  }

  @Override
  public String display() {
    return "Statistics conditions:%n" +
      "Min Temperature: %s U00B0C%n".formatted(minTemperature) +
      "Max Temperature: %s U00B0C%n".formatted(maxTemperature) +
      "Min Humidity: %s %%%n".formatted(minHumidity) +
      "Max Humidity: %s %%%n".formatted(maxHumidity) +
      "Min Pressure: %s bar%n".formatted(minPressure) +
      "Max Pressure: %s bar%n".formatted(maxPressure);
  }
}
