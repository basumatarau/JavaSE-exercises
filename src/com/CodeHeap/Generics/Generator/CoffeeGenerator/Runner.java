package com.CodeHeap.Generics.Generator.CoffeeGenerator;

public class Runner {
    public static void main(String[] args) {

        CoffeeGenerator generator = new CoffeeGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(generator.next());
        }

        for (Coffee coffee : new CoffeeGenerator(5)) {
            System.out.println(coffee);
        }
    }
}
