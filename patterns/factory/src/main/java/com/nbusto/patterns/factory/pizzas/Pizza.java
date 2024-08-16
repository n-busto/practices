package com.nbusto.patterns.factory.pizzas;

import com.nbusto.patterns.factory.ingredients.PizzaIngredientFactory;
import com.nbusto.patterns.factory.ingredients.cheese.Cheese;
import com.nbusto.patterns.factory.ingredients.dough.Dough;
import com.nbusto.patterns.factory.ingredients.pepperoni.Pepperoni;
import com.nbusto.patterns.factory.ingredients.sauce.Sauce;
import com.nbusto.patterns.factory.ingredients.veggies.Veggie;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Pizza {
    private final String name;
    private final Dough dough;
    private final Sauce sauce;
    private final Cheese cheese;
    private final List<Veggie> veggies;

    public Pizza(String name, PizzaIngredientFactory ingredientFactory) {
        this.name = name;
        this.dough = ingredientFactory.createDough();
        this.sauce = ingredientFactory.createSauce();
        this.cheese = ingredientFactory.createCheese();
        this.veggies = Stream.of(ingredientFactory.createVeggies()).collect(Collectors.toList());
    }

    public void prepare() {
        System.out.println("Preparing " + name);
        System.out.println("Tossing " + dough + "...");
        System.out.println("Adding " + sauce + "...");
        System.out.println("Adding " + cheese + "...");
        System.out.println("Adding veggies:");
        veggies
                .stream()
                .map(Object::toString)
                .map("   "::concat)
                .forEach(System.out::println);
    }

    public void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    public void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName() {
        return name;
    }
}
