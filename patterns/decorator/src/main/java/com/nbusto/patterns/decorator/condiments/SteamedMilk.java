package com.nbusto.patterns.decorator.condiments;

import com.nbusto.patterns.decorator.Component;
import com.nbusto.patterns.decorator.Decorator;

import java.math.BigDecimal;

public class SteamedMilk extends Decorator {
  protected SteamedMilk(Component wrappedObject) {
    super(wrappedObject, BigDecimal.valueOf(.10));
  }
}
