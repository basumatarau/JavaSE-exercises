package com.codeHeap.generics.reflectionFactory.factoryConstraint;

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
