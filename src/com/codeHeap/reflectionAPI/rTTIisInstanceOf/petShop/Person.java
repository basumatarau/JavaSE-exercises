package com.codeHeap.reflectionAPI.rTTIisInstanceOf.petShop;

public class Person extends Individual{
    public Person(String name){
        super(name);
    }

    public static class Factory implements com.codeHeap.reflectionAPI.rTTIisInstanceOf.petShop.Factory{
        @Override
        public Object create() {
            return new Person("Valera");
        }
    }
}
