package com.CodeHeap.Generics.GeneralizedMethods;

import com.CodeHeap.Generics.Generator.CoffeeGenerator.Generator;

public class BasicGenerator<T> implements Generator<T> {

    Class<T> type;
    public BasicGenerator(Class<T> type){
        this.type = type;
    }

    @Override
    public T next() {
        try {
            return type.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> Generator<T> instantiateGen(Class<T> type){
        return new BasicGenerator<T>(type);
    }


    public static void main(String[] args) {
        BasicGenerator<Dummy> dummyGenerator = new BasicGenerator<>(Dummy.class);
        for (int i = 0; i < 5; i++) {
            System.out.println(dummyGenerator.next());
        }
        Generator<Dummy> dummyGenerator1 = BasicGenerator.instantiateGen(Dummy.class);
        for (int i = 0; i < 5; i++) {
            System.out.println(dummyGenerator1.next());
        }
    }
}
