package com.nbusto.patterns.factory.ingredients;

import com.nbusto.patterns.factory.ingredients.cheese.Cheese;
import com.nbusto.patterns.factory.ingredients.cheese.ReggianoCheese;
import com.nbusto.patterns.factory.ingredients.clams.Clam;
import com.nbusto.patterns.factory.ingredients.clams.FreshClam;
import com.nbusto.patterns.factory.ingredients.dough.Dough;
import com.nbusto.patterns.factory.ingredients.dough.ThinCrustDough;
import com.nbusto.patterns.factory.ingredients.pepperoni.Pepperoni;
import com.nbusto.patterns.factory.ingredients.pepperoni.SlicedPepperoni;
import com.nbusto.patterns.factory.ingredients.sauce.MarinaraSauce;
import com.nbusto.patterns.factory.ingredients.sauce.Sauce;
import com.nbusto.patterns.factory.ingredients.veggies.*;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
  @Override
  public Dough createDough() {
    return new ThinCrustDough();
  }

  @Override
  public Sauce createSauce() {
    return new MarinaraSauce();
  }

  @Override
  public Cheese createCheese() {
    return new ReggianoCheese();
  }

  @Override
  public Veggie[] createVeggies() {
    return new Veggie[]{new Garlic(), new Onion(), new Mushroom(), new RedPepper()};
  }

  @Override
  public Pepperoni createPepperoni() {
    return new SlicedPepperoni();
  }

  @Override
  public Clam createClams() {
    return new FreshClam();
  }
}
