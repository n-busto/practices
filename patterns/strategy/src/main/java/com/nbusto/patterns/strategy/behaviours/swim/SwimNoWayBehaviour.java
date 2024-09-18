package com.nbusto.patterns.strategy.behaviours.swim;

public class SwimNoWayBehaviour implements SwimBehaviour {
  @Override
  public String swim() {
    return "do nothing";
  }
}
