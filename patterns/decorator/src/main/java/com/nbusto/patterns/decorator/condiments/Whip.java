package com.nbusto.patterns.decorator.condiments;

import com.nbusto.patterns.decorator.Component;
import com.nbusto.patterns.decorator.Decorator;

import java.math.BigDecimal;

public class Whip extends Decorator {
  protected Whip(Component wrappedObject) {
    super(wrappedObject, BigDecimal.valueOf(.10));
  }
}
