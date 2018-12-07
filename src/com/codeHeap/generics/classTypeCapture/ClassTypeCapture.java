package com.codeHeap.generics.classTypeCapture;

import com.codeHeap.generics.generator.coffeeGenerator.Coffee;
import com.codeHeap.generics.generator.coffeeGenerator.Latte;

import java.util.HashMap;
import java.util.Map;

public class ClassTypeCapture {
    private static Map<String, IFactory<?>> types = new HashMap<>();

    public static void addType(String typeName, IFactory<?> factoryObj) throws Exception {
        for (Map.Entry<String, IFactory<?>> entry : types.entrySet()) {
            if (entry.getKey().equals(typeName)) {
                throw new Exception("type " + typeName + " has been already registered");
            }
        }
        types.put(typeName, factoryObj);
    }

    public static Object createNew(String typeName) throws Exception {
        for (Map.Entry<String, IFactory<?>> entry : types.entrySet()) {
            if (entry.getKey().equals(typeName)) {
                return entry.getValue().create();
            }
        }
        throw new Exception("unregistered type name " + typeName);
    }

    public static void main(String[] args) throws Exception{
        addType("string", ()->{
                return "this is a default string";
        });
        addType("qwerty", Latte::new);
        addType("latte", Coffee::new);


        System.out.println(createNew("string"));
        System.out.println(createNew("qwerty"));
        System.out.println(createNew("latte"));
    }

}
