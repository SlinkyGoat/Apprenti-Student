package org.example;

public class Fridge implements Connectable{

    private boolean isPowerOn;

    public Fridge(){
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
        return "Fridge";
    }

}
