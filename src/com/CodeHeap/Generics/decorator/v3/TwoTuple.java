package com.CodeHeap.Generics.decorator.v3;

public class TwoTuple<OBJECT, CLASS> {
    private OBJECT object;
    private CLASS type;
    public TwoTuple(OBJECT object, CLASS type){
        this.object = object;
        this.type = type;
    }
    public OBJECT getObject(){
        return object;
    }

    public CLASS getType() {
        return type;
    }
    public static <OBJECT, CLASS> TwoTuple<OBJECT, CLASS> makeTuple(OBJECT object, CLASS type){
        return new TwoTuple<>(object, type);
    }
}
