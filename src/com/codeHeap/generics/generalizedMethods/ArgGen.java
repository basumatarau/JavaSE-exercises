package com.codeHeap.generics.generalizedMethods;

import com.codeHeap.reflectionAPI.rTTIisInstanceOf.petShop.Person;
import com.codeHeap.reflectionAPI.rTTIisInstanceOf.petShop.Pet;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ArgGen {

    private static void f(Map<Person, List<? extends Pet>> petOwners){}

    public static void main(String[] args) {
        List<String> strings = New.list();
        strings.addAll(Arrays.asList("some Test string goes here".split(" ")));
        for (String string : strings) {
            System.out.println(string);
        }

        //Map<Person, List<? extends Pet>> petOwners = New.map();

        //hm...what?
        f(New.map());

    }
}
