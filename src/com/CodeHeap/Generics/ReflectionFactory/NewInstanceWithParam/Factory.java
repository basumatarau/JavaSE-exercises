package com.CodeHeap.Generics.ReflectionFactory.NewInstanceWithParam;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Factory<T> implements IFactory<T> {
    private Class<T> type;

    public <F extends Class<T>> Factory(F type){
        this.type = type;
    }

    @Override
    public Object create() {
        try {
            return type.newInstance();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object create(Object... param) {
        for (Constructor<?> constructor : type.getConstructors()) {
            try {
                return constructor.newInstance(param);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                continue;
            }
        }
        throw new RuntimeException("constructor not found...");
    }

    public static void main(String[] args) {
        Factory<SomeType> someTypeFactory = new Factory<>(SomeType.class);
        SomeType obj = (SomeType)someTypeFactory.create("this is an initializer string");
        System.out.println(obj.getSomeStr());
    }
}
