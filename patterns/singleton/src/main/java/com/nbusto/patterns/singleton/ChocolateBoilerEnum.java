package com.nbusto.patterns.singleton;

public enum ChocolateBoilerEnum {
    UNIQUE_INSTANCE;

    private boolean empty;
    private boolean boiled;

    ChocolateBoilerEnum() {
        this.empty = true;
        this.boiled = false;
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
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
