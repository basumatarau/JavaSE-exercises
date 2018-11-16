package com.CodeHeap.Generics.ReflectionFactory.FactoryConstraint;

public class StringFactory implements IFacotory<String>{
    @Override
    public String create(Object... args) {
        StringBuilder result = new StringBuilder();
        for (Object arg : args) {
            result.append(arg).append(", ");
        }
        return result.toString();
    }
}
