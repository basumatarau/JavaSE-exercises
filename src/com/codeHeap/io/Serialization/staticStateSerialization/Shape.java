package com.codeHeap.io.Serialization.staticStateSerialization;

import java.io.Serializable;
import java.util.Random;

public abstract class Shape implements Serializable {
    public static final int RED = 1, BLUE = 2, GREEN = 3;
    private int xPos, yPos, dimension;
    private static Random random = new Random(47);
    private static int counter = 0;
    public abstract void setColor(int color);
    public abstract int getColor();

    public Shape (int xVal, int yVal, int dimension){
        xPos = xVal;
        yPos = yVal;
        this.dimension = dimension;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " color["+ getColor()
                + "] xPos[" + xPos +"] yPos["+yPos+"] dimension["
                + dimension +"]\n";
    }

    public static Shape randomFactory(){
        int xVal = random.nextInt(100);
        int yVal = random.nextInt(100);
        int dimension = random.nextInt(100);

        switch (counter++%3){
            case 0:
                return new Circle(xVal, yVal, dimension);
            case 1:
                return new Square(xVal, yVal, dimension);
            default:
                return new Line(xVal, yVal, dimension);
        }
    }
}
