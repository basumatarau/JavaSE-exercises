package com.CodeHeap.ReflectionAPI.RTTIisInstanceOf.PetShop;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator{

    private static List<Factory<? extends Pet>> factories = new ArrayList<>();

    private static String[] typeNames = {
            "com.CodeHeap.ReflectionAPI.RTTIisInstanceOf.PetShop.Cat$SomeTypeFactory",
            "com.CodeHeap.ReflectionAPI.RTTIisInstanceOf.PetShop.Dog$SomeTypeFactory",
            "com.CodeHeap.ReflectionAPI.RTTIisInstanceOf.PetShop.EgiptianMau$SomeTypeFactory",
            "com.CodeHeap.ReflectionAPI.RTTIisInstanceOf.PetShop.Hamster$SomeTypeFactory",
            "com.CodeHeap.ReflectionAPI.RTTIisInstanceOf.PetShop.Mouse$SomeTypeFactory",
            "com.CodeHeap.ReflectionAPI.RTTIisInstanceOf.PetShop.Mutt$SomeTypeFactory",
            "com.CodeHeap.ReflectionAPI.RTTIisInstanceOf.PetShop.Pug$SomeTypeFactory",
            "com.CodeHeap.ReflectionAPI.RTTIisInstanceOf.PetShop.Rat$SomeTypeFactory"
    };

    static{
        loader();
    }

    @SuppressWarnings("unchecked")
    private static void loader(){
        try{
            for (String typeName : typeNames) {
                factories.add(
                        ((Class<Factory<? extends Pet>>)Class.forName(typeName)).newInstance()
                );
            }
        }catch (ClassNotFoundException | IllegalAccessException | InstantiationException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Factory<? extends Pet> factory : factories) {
            sb.append(factory.getClass().getSimpleName()).append(", ");
        }
        return sb.toString();
    }

    @Override
    public List<Factory<? extends Pet>> register() {
        return factories;
    }
}
