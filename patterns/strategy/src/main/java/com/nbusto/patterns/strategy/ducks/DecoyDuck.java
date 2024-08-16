package com.nbusto.patterns.strategy.ducks;

import com.nbusto.patterns.strategy.behaviours.fly.FlyNoWayBehaviour;
import com.nbusto.patterns.strategy.behaviours.quack.MuteBehaviour;
import com.nbusto.patterns.strategy.behaviours.swim.SwimNoWayBehaviour;

public class DecoyDuck extends Duck {
    public DecoyDuck() {
        super(new FlyNoWayBehaviour(), new MuteBehaviour(), new SwimNoWayBehaviour());
    }

    @Override
    public String display() {
        return "decoy duck";
    }
}
