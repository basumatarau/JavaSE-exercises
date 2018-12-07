package com.codeHeap.generics.covariance.playingAround;


import com.codeHeap.reflectionAPI.rTTIisInstanceOf.petShop.Cat;
import com.codeHeap.reflectionAPI.rTTIisInstanceOf.petShop.Dog;
import com.codeHeap.reflectionAPI.rTTIisInstanceOf.petShop.Pet;

public class Tester {

    static <T> void testMethod(Generic1<? super T> obj, T obj2){
        obj.setInstance(obj2);
    }

    public static void main(String[] args) {
        Generic1<Pet> petHolder = new Generic1<>();

        petHolder.setInstance(new Cat());
        System.out.println(petHolder.getInstance());
        testMethod(petHolder, new Dog());
        System.out.println(petHolder.getInstance());
        testMethod(petHolder, new Pet());
        System.out.println(petHolder.getInstance());
    }
}
