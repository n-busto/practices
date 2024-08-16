package com.nbusto.patterns.command.devices;

public interface GardenLight {
    void setDuskTime();

    void setDawnTime();

    void manualOn();

    void manualOff();
}
