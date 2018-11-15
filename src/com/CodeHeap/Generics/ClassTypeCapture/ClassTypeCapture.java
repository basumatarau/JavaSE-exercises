package com.CodeHeap.Generics.ClassTypeCapture;

import com.CodeHeap.Generics.Generator.CoffeeGenerator.Coffee;
import com.CodeHeap.Generics.Generator.CoffeeGenerator.Latte;

import java.util.HashMap;
import java.util.Map;

public class ClassTypeCapture {
    private static Map<String, Class<?>> types = new HashMap<>();

    public static void addType(String typeName, Class<?> type) throws Exception {
        for (Map.Entry<String, Class<?>> entry : types.entrySet()) {
            if (entry.getKey().equals(typeName)) {
                throw new Exception("type " + typeName + " has been already registered");
            }
        }
        types.put(typeName, type);
    }

    public static Object createNew(String typeName) throws Exception {
        for (Map.Entry<String, Class<?>> entry : types.entrySet()) {
            if (entry.getKey().equals(typeName)) {
                return entry.getValue().newInstance();
            }
        }
        throw new Exception("unregistered type name " + typeName);
    }

    public static void main(String[] args) throws Exception{
        addType("string", String.class);
        addType("qwerty", Coffee.class);
        addType("latte", Latte.class);


        System.out.println(createNew("string"));
        System.out.println(createNew("qwerty"));
        System.out.println(createNew("latte"));
    }

}
