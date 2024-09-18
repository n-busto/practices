package com.nbusto.patterns.factory.pizzas;

import com.nbusto.patterns.factory.ingredients.PizzaIngredientFactory;
import com.nbusto.patterns.factory.ingredients.pepperoni.Pepperoni;

public class PepperoniPizza extends Pizza {
  private final Pepperoni pepperoni;

  public PepperoniPizza(PizzaIngredientFactory factory) {
    super("Pepperoni pizza", factory);
    this.pepperoni = factory.createPepperoni();
  }

  @Override
  public void prepare() {
    super.prepare();
    System.out.println("Adding " + pepperoni + "...");
  }
}
