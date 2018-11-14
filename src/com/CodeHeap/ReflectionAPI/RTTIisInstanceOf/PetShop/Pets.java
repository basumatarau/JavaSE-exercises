package com.CodeHeap.ReflectionAPI.RTTIisInstanceOf.PetShop;

import java.util.List;

public class Pets {
    public static final PetCreator creator = new ForNameCreator();

    public static Pet randomPet(){
        return creator.getRandomPet();
    }

    public static Pet[] getPetArray(){
        return creator.getRandomPetArray(20);
    }

    public static List<Pet> getPetList(){
        return creator.getListesRndPets(20);
    }
}
