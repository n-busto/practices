package com.nbusto.patterns.decorator;

import java.math.BigDecimal;

public abstract class Decorator implements Component {
    private final Component wrappedObject;
    private final BigDecimal cost;

    protected Decorator(Component wrappedObject, BigDecimal cost) {
        this.wrappedObject = wrappedObject;
        this.cost = cost;
    }

    @Override
    public BigDecimal cost() {
        return cost.add(wrappedObject.cost());
    }
}
