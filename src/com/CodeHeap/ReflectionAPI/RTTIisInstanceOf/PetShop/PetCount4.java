package com.CodeHeap.ReflectionAPI.RTTIisInstanceOf.PetShop;

public class PetCount4 {
    public static void main(String[] args) {
        TypeCounter typeCounter = new TypeCounter(Individual.class);
        for (Pet pet : Pets.getPetList()) {
            System.out.println(pet.getClass().getSimpleName()+", ");
            typeCounter.count(pet);
        }
        System.out.println();
        System.out.println(typeCounter);
    }
}
