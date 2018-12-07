package com.codeHeap.reflectionAPI.rTTIisInstanceOf.petShop;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator{

    private static List<Factory<? extends Pet>> factories = new ArrayList<>();

    private static String[] typeNames = {
            "com.codeHeap.reflectionAPI.rTTIisInstanceOf.petShop.Cat$SomeTypeFactory",
            "com.codeHeap.reflectionAPI.rTTIisInstanceOf.petShop.Dog$SomeTypeFactory",
            "com.codeHeap.reflectionAPI.rTTIisInstanceOf.petShop.EgiptianMau$SomeTypeFactory",
            "com.codeHeap.reflectionAPI.rTTIisInstanceOf.petShop.Hamster$SomeTypeFactory",
            "com.codeHeap.reflectionAPI.rTTIisInstanceOf.petShop.Mouse$SomeTypeFactory",
            "com.codeHeap.reflectionAPI.rTTIisInstanceOf.petShop.Mutt$SomeTypeFactory",
            "com.codeHeap.reflectionAPI.rTTIisInstanceOf.petShop.Pug$SomeTypeFactory",
            "com.codeHeap.reflectionAPI.rTTIisInstanceOf.petShop.Rat$SomeTypeFactory"
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
