package com.CodeHeap.Generics.decorator.v3;

public class TwoTuple<T, T2> {
    private T first;
    private T2 second;
    public TwoTuple(T object, T2 type){
        this.first = object;
        this.second = type;
    }
    public T getFirst(){
        return first;
    }

    public T2 getSecond() {
        return second;
    }
    public static <TYPE1, TYPE2> TwoTuple<TYPE1 , TYPE2> makeTuple(TYPE1 object, TYPE2 type){
        return new TwoTuple<>(object, type);
    }
}
