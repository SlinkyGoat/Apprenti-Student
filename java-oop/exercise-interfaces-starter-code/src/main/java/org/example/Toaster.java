package org.example;

public class Toaster implements Connectable{

    private boolean isPowerOn;

    public Toaster(){
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
        return "Toaster";
    }

}
