package com.nbusto.patterns.factory.stores;

import com.nbusto.patterns.factory.ingredients.PizzaIngredientFactory;
import com.nbusto.patterns.factory.pizzas.*;

public abstract class PizzaStore {
    private final PizzaIngredientFactory ingredientFactory;

    protected PizzaStore(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    public Pizza orderPizza(String type) {
        final var pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    private Pizza createPizza(String type) {
        return switch (type) {
            case "cheese" -> new CheesePizza(ingredientFactory);
            case "pepperoni" -> new PepperoniPizza(ingredientFactory);
            case "clam" -> new ClamPizza(ingredientFactory);
            case "veggie" -> new VeggiePizza(ingredientFactory);
            default -> throw new RuntimeException("Not supported pizza");
        };
    }
}
