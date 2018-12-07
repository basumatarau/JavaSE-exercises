package com.codeHeap.reflectionAPI.rTTIisInstanceOf.petShop;

public class Individual {
    private String name;
    Individual(){
        this.name = "";
    }
    Individual(String name){
        this.name = name;
    }
    public static class Factory implements com.codeHeap.reflectionAPI.rTTIisInstanceOf.petShop.Factory{
        @Override
        public Object create() {
            return new Individual();
        }
    }
}
