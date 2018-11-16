package com.CodeHeap.Generics.ReflectionFactory.NewInstanceWithParam;

public class SomeType {
    private String someStr;
    public SomeType(){
        this.someStr = "default string";
    }
    public SomeType(String someStr){
        this.someStr = someStr;
    }
    public String getSomeStr() {
        return someStr;
    }
}
