package com.CodeHeap.ReflectionAPI.RTTIisInstanceOf.PetShop;

import java.util.LinkedHashMap;
import java.util.Map;

public class PetCount3 {

    static class PetCounter extends LinkedHashMap<Class<? extends Pet>, Integer> {
        PetCounter(){
            for (Factory<? extends Pet> factory : LiteralPetCreator.allFactories) {
                put(factory.create().getClass(), 0);
            }
        }

        public void count(Pet pet){
            for (Map.Entry<Class<? extends Pet>, Integer> entry : entrySet()) {
                if(entry.getKey().isInstance(pet)){
                    put(entry.getKey(), entry.getValue()+1);
                }
            }
        }

        @Override
        public String toString() {

            StringBuilder result = new StringBuilder("{");
            String delimiter = "";
            String pairConnector = "=";

            for (Map.Entry<Class<? extends Pet>, Integer> entry : entrySet()) {
                result.append(delimiter)
                        .append(entry.getKey().getSimpleName())
                        .append(pairConnector)
                        .append(entry.getValue());
                delimiter = ", ";
            }
            result.append("}");

            return result.toString();
        }
    }

    public static void main(String[] args) {
        PetCounter petCounter = new PetCounter();
        for (Pet pet : Pets.getPetList()) {
            System.out.print(pet.getClass().getSimpleName()+", ");
            petCounter.count(pet);
        }
        System.out.println();
        System.out.println(petCounter);
    }

}
