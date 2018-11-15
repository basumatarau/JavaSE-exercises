package com.CodeHeap.Generics.GeneralizedMethods;

import com.CodeHeap.Generics.Generator.CoffeeGenerator.Coffee;
import com.CodeHeap.Generics.Generator.CoffeeGenerator.CoffeeGenerator;
import com.CodeHeap.Generics.Generator.CoffeeGenerator.Generator;
import com.CodeHeap.Generics.Generator.Fibonacci.Fibonacci;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Generators {
    static <T> Collection<T> fill(Generator<T> generator, Collection<T> collection, int capacity){
        while(capacity>0){
            capacity--;
            collection.add(generator.next());
        }
        return collection;
    }

    static <T> Collection<T> fill(Generator<T> generator, List<T> collection, int capacity){
        System.out.println("fill(); with List<T> param");
        while(capacity>0){
            capacity--;
            collection.add(generator.next());
        }
        return collection;
    }

    static <T> Collection<T> fill(Generator<T> generator, LinkedList<T> collection, int capacity){
        System.out.println("fill(); with LinkedList<T> param");
        while(capacity>0){
            capacity--;
            collection.add(generator.next());
        }
        return collection;
    }

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        fill(new Fibonacci(), integers, 20);

        for (Integer integer : integers) {
            System.out.println(integer);
        }

        
    }
}
