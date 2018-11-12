package com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator{

    private static List<Factory<? extends Pet>> factories = new ArrayList<>();

    private static String[] typeNames = {
            "com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop.Cat$Factory",
            "com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop.Dog$Factory",
            "com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop.EgiptianMau$Factory",
            "com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop.Hamster$Factory",
            "com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop.Mouse$Factory",
            "com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop.Mutt$Factory",
            "com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop.Pug$Factory",
            "com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop.Rat$Factory"
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
