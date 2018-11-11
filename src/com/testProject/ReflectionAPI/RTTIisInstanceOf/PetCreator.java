package com.testProject.ReflectionAPI.RTTIisInstanceOf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class PetCreator {
    private Random rand = new Random(47);
    public abstract List<Class<? extends Pet>> types();

    public Pet getRandomPet(){
        try{
            return types().
                    get(rand.nextInt(types().size()))
                    .newInstance();
        }catch (InstantiationException | IllegalAccessException e){
            throw new RuntimeException(e);
        }
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
