package com.nbusto.patterns.strategy.behaviours.quack;

public class QuackBehaviour implements QuakingBehaviour{
    @Override
    public String quack() {
        return "quack";
    }
}
