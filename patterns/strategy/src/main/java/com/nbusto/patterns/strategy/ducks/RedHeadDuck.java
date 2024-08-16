package com.nbusto.patterns.strategy.ducks;

import com.nbusto.patterns.strategy.behaviours.fly.FlyWithWingsBehaviour;
import com.nbusto.patterns.strategy.behaviours.quack.QuackBehaviour;
import com.nbusto.patterns.strategy.behaviours.swim.RegularSwimBehaviour;

public class RedHeadDuck extends Duck{
    public RedHeadDuck() {
        super(new FlyWithWingsBehaviour(), new QuackBehaviour(), new RegularSwimBehaviour());
    }

    @Override
    public String display() {
        return "red head duck";
    }
}
