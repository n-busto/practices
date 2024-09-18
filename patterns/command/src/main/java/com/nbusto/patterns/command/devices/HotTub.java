package com.nbusto.patterns.command.devices;

public interface HotTub {
  void circulate();

  void jetsOn();

  void jetsOff();

  void setTemperature();
}
