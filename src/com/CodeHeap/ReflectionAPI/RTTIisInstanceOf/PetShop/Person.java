package com.CodeHeap.ReflectionAPI.RTTIisInstanceOf.PetShop;

public class Person extends Individual{
    public Person(String name){
        super(name);
    }

    public static class Factory implements com.CodeHeap.ReflectionAPI.RTTIisInstanceOf.PetShop.Factory{
        @Override
        public Object create() {
            return new Person("Valera");
        }
    }
}
