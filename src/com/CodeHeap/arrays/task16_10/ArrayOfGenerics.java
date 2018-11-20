package com.CodeHeap.arrays.task16_10;

import com.CodeHeap.Generics.GeneralizedMethods.Generators;
import com.CodeHeap.Generics.Generator.CoffeeGenerator.Coffee;
import com.CodeHeap.Generics.Generator.CoffeeGenerator.Latte;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArrayOfGenerics {
    public static void main(String[] args) {
        List<String>[] ls;
        List[] la = new List[10];
        ls = (List<String>[])la;

        List<List<String>> ls2;
        List<List> la2 = new ArrayList<>();
        //ls2 = (List<List<String>>)la2;


        ls[0] = new ArrayList<String>();
        //ls[1] = new ArrayList<Integer>();

        Object[] objects = ls;
        objects[1] = new ArrayList<Integer>();

        List<Coffee>[] coffeeLists = (List<Coffee>[])new List[10];
        for (int i = 0; i < coffeeLists.length; i++) {
            Collection<Latte> collection = Generators.fill(Latte::new, new ArrayList<>(), 10);
            coffeeLists[i] = (ArrayList)collection;
        }
        for (List<Coffee> coffeeList : coffeeLists) {
            System.out.println(coffeeList);
        }
    }
}
