package com.nbusto.patterns.factory.stores;

import com.nbusto.patterns.factory.ingredients.NYPizzaIngredientFactory;

public class NYPizzaStore extends PizzaStore {
  protected NYPizzaStore() {
    super(new NYPizzaIngredientFactory());
  }
}
