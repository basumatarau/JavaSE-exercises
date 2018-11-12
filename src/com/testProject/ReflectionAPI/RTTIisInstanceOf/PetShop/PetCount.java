package com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop;

import java.util.HashMap;

public class PetCount {
    static class PetCounter extends HashMap<String, Integer>{
        public void count(String type){
            Integer quantity = get(type);
            if(quantity==null){
                put(type, 1);
            }else {
                put(type, ++quantity);
            }
        }
    }

    public static void countPets(PetCreator creator){
        PetCounter counter = new PetCounter();

        for (Pet pet : creator.getListesRndPets(20)) {
            System.out.println(pet.getClass().getSimpleName());
            if(pet instanceof Pet)
                counter.count("Pet");
            if(pet instanceof Dog)
                counter.count("Dog");
            if(pet instanceof Mutt)
                counter.count("Mutt");
            if(pet instanceof Pug)
                counter.count("Pug");
            if(pet instanceof Cat)
                counter.count("Cat");
            if(pet instanceof EgiptianMau)
                counter.count("EgiptianMau");
            if(pet instanceof Rodent)
                counter.count("Rodent");
            if(pet instanceof Mouse)
                counter.count("Mouse");
            if(pet instanceof Rat)
                counter.count("Rat");
            if(pet instanceof Hamster)
                counter.count("Hamster");
        }
        System.out.println(creator);
        System.out.println(counter);
    }

    public static void main(String[] args) {
        countPets(new ForNameCreator());
        System.out.println("---");
        countPets(new LiteralPetCreator());
    }
}
