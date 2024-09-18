package com.nbusto.patterns.factory.ingredients;

import com.nbusto.patterns.factory.ingredients.cheese.Cheese;
import com.nbusto.patterns.factory.ingredients.cheese.MozzarellaCheese;
import com.nbusto.patterns.factory.ingredients.clams.Clam;
import com.nbusto.patterns.factory.ingredients.clams.FrozenClam;
import com.nbusto.patterns.factory.ingredients.dough.Dough;
import com.nbusto.patterns.factory.ingredients.dough.ThickCrustDough;
import com.nbusto.patterns.factory.ingredients.pepperoni.Pepperoni;
import com.nbusto.patterns.factory.ingredients.pepperoni.SlicedPepperoni;
import com.nbusto.patterns.factory.ingredients.sauce.PlumTomatoSauce;
import com.nbusto.patterns.factory.ingredients.sauce.Sauce;
import com.nbusto.patterns.factory.ingredients.veggies.BlackOlives;
import com.nbusto.patterns.factory.ingredients.veggies.EggPlant;
import com.nbusto.patterns.factory.ingredients.veggies.Spinach;
import com.nbusto.patterns.factory.ingredients.veggies.Veggie;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
  @Override
  public Dough createDough() {
    return new ThickCrustDough();
  }

  @Override
  public Sauce createSauce() {
    return new PlumTomatoSauce();
  }

  @Override
  public Cheese createCheese() {
    return new MozzarellaCheese();
  }

  @Override
  public Veggie[] createVeggies() {
    return new Veggie[]{new Spinach(), new BlackOlives(), new EggPlant()};
  }

  @Override
  public Pepperoni createPepperoni() {
    return new SlicedPepperoni();
  }

  @Override
  public Clam createClams() {
    return new FrozenClam();
  }
}
