package com.testProject.ReflectionAPI.RTTIisInstanceOf;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator{

    private static List<Class<? extends Pet>> types = new ArrayList<>();

    private static String[] typeNames = {
            "com.testProject.ReflectionAPI.RTTIisInstanceOf.Cat",
            "com.testProject.ReflectionAPI.RTTIisInstanceOf.Dog",
            "com.testProject.ReflectionAPI.RTTIisInstanceOf.EgiptianMau",
            "com.testProject.ReflectionAPI.RTTIisInstanceOf.Hamster",
            "com.testProject.ReflectionAPI.RTTIisInstanceOf.Mouse",
            "com.testProject.ReflectionAPI.RTTIisInstanceOf.Mutt",
            "com.testProject.ReflectionAPI.RTTIisInstanceOf.Pug",
            "com.testProject.ReflectionAPI.RTTIisInstanceOf.Rat"
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
