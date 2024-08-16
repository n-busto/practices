package com.nbusto.patterns.strategy.behaviours.quack;

public class SqueakBehaviour implements QuakingBehaviour{
    @Override
    public String quack() {
        return "squeak";
    }
}
