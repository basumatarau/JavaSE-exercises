package com.codeHeap.reflectionAPI.rTTIisInstanceOf.petShop;

public class Hamster extends Rodent {
    public Hamster() {
        super();
    }

    public Hamster(String name) {
        super(name);
    }

    public static class Factory implements com.codeHeap.reflectionAPI.rTTIisInstanceOf.petShop.Factory{
        @Override
        public Object create() {
            return new Hamster();
        }
    }
}
