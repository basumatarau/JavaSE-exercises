package com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator{

    private static List<Class<? extends Pet>> types = new ArrayList<>();

    private static String[] typeNames = {
            "com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop.Cat",
            "com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop.Dog",
            "com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop.EgiptianMau",
            "com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop.Hamster",
            "com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop.Mouse",
            "com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop.Mutt",
            "com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop.Pug",
            "com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop.Rat"
    };

    static{
        loader();
    }

    @SuppressWarnings("unchecked")
    private static void loader(){
        try{
            for (String typeName : typeNames) {
                types.add(
                        (Class<? extends Pet>)Class.forName(typeName)
                );
            }
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Class<? extends Pet> type : types) {
            sb.append(type.getSimpleName()).append(", ");
        }
        return sb.toString();
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}
