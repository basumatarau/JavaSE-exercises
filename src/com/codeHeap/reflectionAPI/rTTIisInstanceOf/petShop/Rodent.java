package com.codeHeap.reflectionAPI.rTTIisInstanceOf.petShop;

public class Rodent extends Pet {
    public Rodent() {
        super();
    }

    public Rodent(String name) {
        super(name);
    }
    public static class Factory implements com.codeHeap.reflectionAPI.rTTIisInstanceOf.petShop.Factory{
        @Override
        public Object create() {
            return new Rodent();
        }
    }
}
