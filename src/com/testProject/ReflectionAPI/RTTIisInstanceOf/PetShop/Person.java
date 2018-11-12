package com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop;

public class Person extends Individual{
    Person(String name){
        super(name);
    }

    public static class Factory implements com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop.Factory{
        @Override
        public Object create() {
            return new Person("Valera");
        }
    }
}
