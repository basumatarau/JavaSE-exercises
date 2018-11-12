package com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop;

public class Dog extends Pet {
    public Dog() {
        super();
    }

    public Dog(String name) {
        super(name);
    }
    public static class Factory implements com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop.Factory{
        @Override
        public Object create() {
            return new Dog();
        }
    }
}
