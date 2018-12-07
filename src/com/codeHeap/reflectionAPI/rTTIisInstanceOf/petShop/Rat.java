package com.codeHeap.reflectionAPI.rTTIisInstanceOf.petShop;

public class Rat extends Rodent {
    public Rat() {
        super();
    }

    public Rat(String name) {
        super(name);
    }
    public static class Factory implements com.codeHeap.reflectionAPI.rTTIisInstanceOf.petShop.Factory{
        @Override
        public Object create() {
            return new Rat();
        }
    }
}
