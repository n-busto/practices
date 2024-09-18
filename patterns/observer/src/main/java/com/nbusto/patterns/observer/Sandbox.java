package com.nbusto.patterns.observer;

import com.nbusto.patterns.observer.display.CurrentConditionsDisplay;
import com.nbusto.patterns.observer.display.DisplayElement;
import com.nbusto.patterns.observer.display.StatisticsDisplay;
import com.nbusto.patterns.observer.subject.WeatherData;

import java.util.Random;

public class Sandbox {
  private static final Random RANDOMIZER = new Random();

  public static void main(String[] args) {
    final var data = new WeatherData();

    final var currentConditions = new CurrentConditionsDisplay();
    final var statistics = new StatisticsDisplay();

    data.registerObserver(currentConditions);
    data.registerObserver(statistics);

    launchData(data, currentConditions, statistics);
    launchData(data, currentConditions, statistics);
  }

  private static void launchData(WeatherData data, DisplayElement... displays) {
    data.measurementsChanged(RANDOMIZER.nextFloat(), RANDOMIZER.nextFloat(), RANDOMIZER.nextFloat());
    data.notifyObservers();

    for (DisplayElement display : displays) {
      System.out.println(display.display());
    }
  }
}
