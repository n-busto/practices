package com.nbusto.patterns.decorator.condiments;

import com.nbusto.patterns.decorator.Component;
import com.nbusto.patterns.decorator.Decorator;

import java.math.BigDecimal;

public class Mocha extends Decorator {
    protected Mocha(Component wrappedObject) {
        super(wrappedObject, BigDecimal.valueOf(.20));
    }
}
