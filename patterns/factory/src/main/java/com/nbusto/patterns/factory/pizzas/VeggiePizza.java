package com.nbusto.patterns.factory.pizzas;

import com.nbusto.patterns.factory.ingredients.PizzaIngredientFactory;

public class VeggiePizza extends Pizza {
  public VeggiePizza(PizzaIngredientFactory factory) {
    super("Veggie pizza", factory);
  }
}
