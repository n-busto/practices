package com.nbusto.patterns.strategy.ducks;

import com.nbusto.patterns.strategy.behaviours.fly.FlyNoWayBehaviour;
import com.nbusto.patterns.strategy.behaviours.quack.SqueakBehaviour;
import com.nbusto.patterns.strategy.behaviours.swim.FloatBehaviour;

public class RubberDuck extends Duck {
  public RubberDuck() {
    super(new FlyNoWayBehaviour(), new SqueakBehaviour(), new FloatBehaviour());
  }

  @Override
  public String quack() {
    return "squeak";
  }

  @Override
  public String display() {
    return "rubber duck";
  }
}
