package com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop;

public class Cat extends Pet {
    public Cat() {
        super();
    }

    public Cat(String name) {
        super(name);
    }

    public static class Factory implements com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop.Factory{
        @Override
        public Object create() {
            return new Cat();
        }
    }
}
