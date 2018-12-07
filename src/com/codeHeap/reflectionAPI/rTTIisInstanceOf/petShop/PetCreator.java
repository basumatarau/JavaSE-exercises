package com.codeHeap.reflectionAPI.rTTIisInstanceOf.petShop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class PetCreator {
    private Random rand = new Random(47);
    public abstract List<Factory<? extends Pet>> register();

    public Pet getRandomPet(){
        return register().
                get(rand.nextInt(register().size()))
                .create();
    }

    public Pet[] getRandomPetArray(int size){
        Pet[] result = new Pet[size];

        for (int i = 0; i < size; i++) {
            result[i] = getRandomPet();
        }
        return result;
    }

    public List<Pet> getListesRndPets(int size){
        ArrayList<Pet> result = new ArrayList<>();
        Collections.addAll(result, getRandomPetArray(size));
        return result;
    }
}
