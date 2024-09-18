package com.nbusto.patterns.singleton;

public class ChocolateBoilerMultithread {
  private static volatile ChocolateBoilerMultithread INSTANCE;

  private boolean empty;
  private boolean boiled;

  private ChocolateBoilerMultithread() {
    empty = true;
    boiled = false;
  }

  public static ChocolateBoilerMultithread getInstance() {
    if (INSTANCE == null) {
      synchronized (ChocolateBoilerMultithread.class) {
        if (INSTANCE == null) {
          INSTANCE = new ChocolateBoilerMultithread();
        }
      }
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
