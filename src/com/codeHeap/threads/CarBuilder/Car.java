package com.codeHeap.threads.CarBuilder;

public class Car {
    private final int id;

    private boolean engine = false, driveTrain = false, wheels = false;

    Car(int id){
        this.id = id;
    }

    Car(){
        this(-1);
    }

    synchronized public int getId(){
        return id;
    }
    synchronized public void addEngine(){
        engine = true;
    }
    synchronized public void addDriveTrain(){
        driveTrain = true;
    }
    synchronized public void addWheels(){
        wheels = true;
    }

    @Override
    public String toString() {
        return "Car " + id + " [" + " engine: " + engine
                + " driveTrain: " + driveTrain
                + " wheels: " + wheels + "]";
    }
}
