package com.nbusto.patterns.strategy.ducks;

import com.nbusto.patterns.strategy.behaviours.fly.FlyWithWingsBehaviour;
import com.nbusto.patterns.strategy.behaviours.quack.QuackBehaviour;
import com.nbusto.patterns.strategy.behaviours.swim.RegularSwimBehaviour;

public class MallardDuck extends Duck {
    public MallardDuck() {
        super(new FlyWithWingsBehaviour(), new QuackBehaviour(), new RegularSwimBehaviour());
    }

    @Override
    public String display() {
        return "mallard duck";
    }
}
