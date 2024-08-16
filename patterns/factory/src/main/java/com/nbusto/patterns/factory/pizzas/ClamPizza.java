package com.nbusto.patterns.factory.pizzas;

import com.nbusto.patterns.factory.ingredients.PizzaIngredientFactory;
import com.nbusto.patterns.factory.ingredients.clams.Clam;

public class ClamPizza extends Pizza {
    private final Clam clam;

    public ClamPizza(PizzaIngredientFactory factory) {
        super("Clam pizza", factory);
        clam = factory.createClams();
    }

    @Override
    public void prepare() {
        super.prepare();
        System.out.println("Adding " + clam + "...");
    }
}
