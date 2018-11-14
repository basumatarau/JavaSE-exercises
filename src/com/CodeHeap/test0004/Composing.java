package com.CodeHeap.test0004;

public class Composing {
    private Shared sharedInstance;

    private static int counter = 0;
    private int ID = ++counter;

    Composing(Shared sharedObj) {
        this.sharedInstance = sharedObj;
        sharedObj.addReference();
    }

    void dispose() {
        System.out.println("Disposing of " + this);
        this.sharedInstance.dispose();
    }

    @Override
    public String toString() {
        return "Composing obj#" + ID;
    }
}
