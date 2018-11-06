package com.testProject.test0004;

public class Shared {
    private int referenceCounter = 0;
    private static int counter = 0;
    private final int ID = ++counter;

    Shared() {
        System.out.println(this + " has been instantiated.");
    }

    void addReference() {
        referenceCounter++;
    }

    void dispose() {
        if (--referenceCounter == 0) {
            System.out.println("Disposing of " + this);
        }
    }

    @Override
    public String toString() {
        return "Shared obj#" + ID;
    }

    public void finalize() {
        if (referenceCounter != 0) {
            throw new RuntimeException(
                    "ERROR: There are still " + referenceCounter + " references pointing at the Shared resource."
            );
        }
    }
}
