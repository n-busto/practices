package com.nbusto.patterns.factory.stores;

import com.nbusto.patterns.factory.ingredients.ChicagoPizzaIngredientFactory;

public class ChicagoPizzaStore extends PizzaStore {
  protected ChicagoPizzaStore() {
    super(new ChicagoPizzaIngredientFactory());
  }
}
