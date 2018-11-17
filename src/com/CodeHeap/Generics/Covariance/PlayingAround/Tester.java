package com.CodeHeap.Generics.Covariance.PlayingAround;


import com.CodeHeap.ReflectionAPI.RTTIisInstanceOf.PetShop.Cat;
import com.CodeHeap.ReflectionAPI.RTTIisInstanceOf.PetShop.Dog;
import com.CodeHeap.ReflectionAPI.RTTIisInstanceOf.PetShop.Pet;

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
