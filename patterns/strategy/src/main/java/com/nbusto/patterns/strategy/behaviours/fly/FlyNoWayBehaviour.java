package com.nbusto.patterns.strategy.behaviours.fly;

public class FlyNoWayBehaviour implements FlyBehaviour {
    @Override
    public String fly() {
        return "do nothing";
    }
}
