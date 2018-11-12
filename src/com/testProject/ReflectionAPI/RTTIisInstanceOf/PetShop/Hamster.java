package com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop;

public class Hamster extends Rodent {
    public Hamster() {
        super();
    }

    public Hamster(String name) {
        super(name);
    }

    public static class Factory implements com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop.Factory{
        @Override
        public Object create() {
            return new Hamster();
        }
    }
}
