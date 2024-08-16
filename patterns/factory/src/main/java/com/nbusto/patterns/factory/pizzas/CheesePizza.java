package com.nbusto.patterns.factory.pizzas;

import com.nbusto.patterns.factory.ingredients.PizzaIngredientFactory;

public class CheesePizza extends Pizza {
    public CheesePizza(PizzaIngredientFactory factory) {
        super("Cheese pizza", factory);
    }
}
