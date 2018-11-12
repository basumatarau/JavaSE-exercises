package com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop;

public class Individual {
    private String name;
    Individual(){
        this.name = "";
    }
    Individual(String name){
        this.name = name;
    }
    public static class Factory implements com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop.Factory{
        @Override
        public Object create() {
            return new Individual();
        }
    }
}
