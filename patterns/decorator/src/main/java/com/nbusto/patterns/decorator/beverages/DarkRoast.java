package com.nbusto.patterns.decorator.beverages;

import com.nbusto.patterns.decorator.Component;

import java.math.BigDecimal;

public class DarkRoast implements Component {
  @Override
  public BigDecimal cost() {
    return BigDecimal.valueOf(.99);
  }
}
