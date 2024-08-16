package com.nbusto.patterns.strategy;

import com.nbusto.patterns.strategy.ducks.*;

public class Display {
    public static void main(String[] args) {
        displayDuck(new MallardDuck());
        displayDuck(new RedHeadDuck());
        displayDuck(new RubberDuck());
        displayDuck(new DecoyDuck());
    }

    private static void displayDuck(Duck duck) {
        System.out.printf("[%s] duck fly[%s] and quack[%s] and swim[%s]%n", duck.display(), duck.fly(), duck.quack(), duck.swim());
    }
}
