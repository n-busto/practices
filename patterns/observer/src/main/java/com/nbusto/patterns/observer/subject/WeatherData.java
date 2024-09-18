package com.nbusto.patterns.observer.subject;

import com.nbusto.patterns.observer.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject<WeatherData> {
  private final List<Observer<WeatherData>> observers = new ArrayList<>();
  private Float temperature;
  private Float humidity;
  private Float pressure;

  public Float getTemperature() {
    return temperature;
  }

  public Float getHumidity() {
    return humidity;
  }

  public Float getPressure() {
    return pressure;
  }

  @Override
  public List<Observer<WeatherData>> getObservers() {
    return observers;
  }

  @Override
  public void registerObserver(Observer<WeatherData> observer) {
    observers.add(observer);
    observer.setSubject(this);
  }

  @Override
  public void removeObserver(Observer<WeatherData> observer) {
    observers.remove(observer);
    observer.setSubject(null);
  }

  public void measurementsChanged(Float temperature, Float humidity, Float pressure) {
    this.temperature = temperature;
    this.humidity = humidity;
    this.pressure = pressure;
    notifyObservers();
  }
}
