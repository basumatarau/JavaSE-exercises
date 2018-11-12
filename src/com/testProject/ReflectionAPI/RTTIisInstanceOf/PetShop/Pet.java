package com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop;

public class Pet extends Individual {
    Pet(){
        super();
    }
    Pet(String name){
        super(name);
    }

    public static class Factory implements com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop.Factory{
        @Override
        public Object create() {
            return new Pet();
        }
    }
}
