package com.codeHeap.io.Serialization.staticStateSerialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StoreCADstate {

    private static String path = System.getProperty("user.dir") + File.separator + "src" + File.separator
            + StoreCADstate.class.getName().replace(StoreCADstate.class.getSimpleName(), "")
            .replaceAll("\\.", File.separator);

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Class<? extends Shape>> shapeTypes = new ArrayList<>();
        shapeTypes.add(Circle.class);
        shapeTypes.add(Line.class);
        shapeTypes.add(Square.class);

        List<Shape> shapes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            shapes.add(Shape.randomFactory());
        }
        System.out.println(shapes);

        for (Shape shape : shapes) {
            shape.setColor(Shape.GREEN);
        }

        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(path+"CADstate.out")
        );

        out.writeObject(shapeTypes);
        Line.serializeStaticState(out);
        out.writeObject(shapes);
        Square.serializeStaticState(out);

        System.out.println(shapes);


        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(path + "CADstate.out")
        );

        List<Class<? extends Shape>> restoredShapeTypes = (List<Class<? extends Shape>>) in.readObject();
        Line.deserializeStaticState(in);
        List<Shape> restoredShapes = (List<Shape>) in.readObject();
        Square.deserializeStaticState(in);

        System.out.println(restoredShapes);

    }
}
