package com.nbusto.patterns.factory.ingredients;

import com.nbusto.patterns.factory.ingredients.cheese.Cheese;
import com.nbusto.patterns.factory.ingredients.clams.Clam;
import com.nbusto.patterns.factory.ingredients.dough.Dough;
import com.nbusto.patterns.factory.ingredients.pepperoni.Pepperoni;
import com.nbusto.patterns.factory.ingredients.sauce.Sauce;
import com.nbusto.patterns.factory.ingredients.veggies.Veggie;

public interface PizzaIngredientFactory {
    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
    Veggie[] createVeggies();
    Pepperoni createPepperoni();
    Clam createClams();
}
