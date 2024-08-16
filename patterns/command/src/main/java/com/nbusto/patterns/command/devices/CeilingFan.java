package com.nbusto.patterns.command.devices;

public interface CeilingFan {
    void high();

    void medium();

    void low();

    void off();

    double getSpeed();
}
