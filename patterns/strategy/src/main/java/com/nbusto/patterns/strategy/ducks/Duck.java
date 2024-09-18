package com.nbusto.patterns.strategy.ducks;

import com.nbusto.patterns.strategy.behaviours.fly.FlyBehaviour;
import com.nbusto.patterns.strategy.behaviours.quack.QuakingBehaviour;
import com.nbusto.patterns.strategy.behaviours.swim.SwimBehaviour;

public abstract class Duck {
  private final FlyBehaviour flyBehaviour;
  private final QuakingBehaviour quackBehaviour;
  private final SwimBehaviour swimBehaviour;

  protected Duck(FlyBehaviour flyBehaviour, QuakingBehaviour quackBehaviour, SwimBehaviour swimBehaviour) {
    this.flyBehaviour = flyBehaviour;
    this.quackBehaviour = quackBehaviour;
    this.swimBehaviour = swimBehaviour;
  }

  public String quack() {
    return quackBehaviour.quack();
  }

  public String swim() {
    return swimBehaviour.swim();
  }

  public String fly() {
    return flyBehaviour.fly();
  }

  public abstract String display();
}
