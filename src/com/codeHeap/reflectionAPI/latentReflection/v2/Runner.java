package com.codeHeap.reflectionAPI.latentReflection.v2;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        FilledList<Shape> shapes = new FilledList<>(Shape.class, 10);

        try {
            Apply.<Shape, List<Shape>>apply(shapes, Shape.class.getMethod("rotate"));
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }


        try {
            Apply.apply(shapes, Shape.class.getMethod("resize", Integer.TYPE), 11);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        try {
            Apply.<Shape, List<Shape>>apply(
                    new FilledList<>(Rectangle.class, 5),
                    Shape.class.getMethod("rotate")
            );
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }


    }
}
