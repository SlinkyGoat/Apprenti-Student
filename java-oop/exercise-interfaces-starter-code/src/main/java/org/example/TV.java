package org.example;

public class TV implements Connectable{

    private boolean isPowerOn;

    public TV(){
        this.isPowerOn = false;
    }

    @Override
    public void turnOn() {
        this.isPowerOn = true;
    }

    @Override
    public void turnOff() {
        this.isPowerOn = false;
    }

    @Override
    public boolean getState() {
        return this.isPowerOn;
    }

    @Override
    public String getName() {
        return "TV";
    }
}
