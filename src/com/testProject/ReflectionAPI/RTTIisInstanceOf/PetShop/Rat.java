package com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop;

public class Rat extends Rodent {
    public Rat() {
        super();
    }

    public Rat(String name) {
        super(name);
    }
    public static class Factory implements com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop.Factory{
        @Override
        public Object create() {
            return new Rat();
        }
    }
}
