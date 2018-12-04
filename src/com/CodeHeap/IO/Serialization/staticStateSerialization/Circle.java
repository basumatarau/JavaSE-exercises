package com.CodeHeap.IO.Serialization.staticStateSerialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Circle extends Shape {
    private static int color = RED;

    public Circle(int xVal, int yVal, int dimension) {
        super(xVal, yVal, dimension);
    }

    @Override
    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public int getColor() {
        return color;
    }

    public static void serializeStaticState(ObjectOutputStream out) throws IOException {
        out.writeObject(color);
    }

    public static void deserializeStaticState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        color = ((Integer) in.readObject());
    }

}
