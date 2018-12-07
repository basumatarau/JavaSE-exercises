package com.codeHeap.generics.selfBounded.sbv1;

public class SomeType extends SelfBounded<SomeType> {
    private String content = "default string";
    SomeType(){}
    SomeType(String str){
        content= str;
    }
    public String getContent(){
        return content;
    }
    public static void main(String[] args) {
        SomeType type = new SomeType();
        type.set(new SomeType("this is a test string"));
        SelfBounded<SomeType> someTypeSelfBounded = type.get();
        System.out.println(type.get().getContent());
        System.out.println(type.getContent());
    }
}

