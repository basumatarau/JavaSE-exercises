package com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop;

public class Rodent extends Pet {
    public Rodent() {
        super();
    }

    public Rodent(String name) {
        super(name);
    }
    public static class Factory implements com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop.Factory{
        @Override
        public Object create() {
            return new Rodent();
        }
    }
}
