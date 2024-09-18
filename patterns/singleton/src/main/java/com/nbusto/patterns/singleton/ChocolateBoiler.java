package com.nbusto.patterns.singleton;

public class ChocolateBoiler {
  private static volatile ChocolateBoiler INSTANCE;

  private boolean empty;
  private boolean boiled;

  private ChocolateBoiler() {
    empty = true;
    boiled = false;
  }

  public static ChocolateBoiler getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new ChocolateBoiler();
    }

    return INSTANCE;
  }

  public void fill() {
    if (empty) {
      empty = false;
      boiled = false;
    }
  }

  public void drain() {
    if (!empty && boiled) {
      empty = true;
    }
  }

  public void boil() {
    if (!empty && !boiled) {
      boiled = true;
    }
  }
}
