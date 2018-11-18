package com.CodeHeap.Generics.SelfBounded.sbv1;

public class AnotherType extends SelfBounded<SomeType> {
    private String anotherContent = "another default content";
    AnotherType(){}
    AnotherType(String string){
        anotherContent = string;
    }

    public String getAnotherContent(){
        return anotherContent;
    }

    public static <T extends SelfBounded> void selfBoundedMethod(T obj){
        System.out.println(obj.get());
    }

    public static void main(String[] args) {
        AnotherType anotherType = new AnotherType();
        anotherType.set(new SomeType("some string..."));

        System.out.println(anotherType.get().getContent());
        System.out.println(anotherType.getAnotherContent());

        SomeType someType = new SomeType();
        someType.set(new SomeType());

        selfBoundedMethod(someType);
    }
}
