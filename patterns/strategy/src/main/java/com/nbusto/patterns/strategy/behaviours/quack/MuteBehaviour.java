package com.nbusto.patterns.strategy.behaviours.quack;

public class MuteBehaviour implements QuakingBehaviour{
    @Override
    public String quack() {
        return "do nothing";
    }
}
