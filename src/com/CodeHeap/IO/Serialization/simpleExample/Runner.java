package com.CodeHeap.IO.Serialization.simpleExample;

import java.io.*;

public class Runner {
    private static String path = System.getProperty("user.dir") + File.separator + "src" + File.separator
            + Runner.class.getName().replace(Runner.class.getSimpleName(), "")
            .replaceAll("\\.", File.separator);

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        ObjectOutputStream out = new ObjectOutputStream (
                new FileOutputStream(path+"worm.out")
        );
        Worm w = new Worm(6, 'a');
        System.out.println("Worm w = "+w);
        out.writeObject("Worm w = ");
        out.writeObject(w);
        out.flush();
        out.close();

        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(path+"worm.out")
        );
        String s = (String)in.readObject();
        Worm worm = (Worm)in.readObject();
        System.out.println(s + worm);
    }
}
