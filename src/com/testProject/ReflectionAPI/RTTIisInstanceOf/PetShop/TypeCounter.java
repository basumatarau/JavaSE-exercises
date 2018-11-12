package com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop;

import java.util.HashMap;

public class TypeCounter extends HashMap<Class<?>, Integer> {
    private Class<?> baseType;
    public TypeCounter(Class<?> baseType){
        this.baseType = baseType;
    }

    public void count(Object obj){
        Class<?> type = obj.getClass();

        if(!baseType.isAssignableFrom(type)){
            throw new RuntimeException(obj + " illegal type: " + type+", must extend "+ baseType);
        }

        countClass(type);
    }

    private void countClass(Class<?> type) {
        Integer quantity = get(type);

        put(type, quantity==null ? 1: ++quantity);

        Class<?> superClass = type.getSuperclass();
        if(superClass!=null && baseType.isAssignableFrom(superClass)){
            countClass(superClass);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        String delimiter = "";
        String pairConnector = "=";

        for (Entry<Class<?>, Integer> entry : entrySet()) {
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
