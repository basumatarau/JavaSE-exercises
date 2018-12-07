package com.codeHeap.reflectionAPI.rTTIisInstanceOf.petShop;

public class Mutt extends Pet {
    public Mutt() {
        super();
    }

    public Mutt(String name) {
        super(name);
    }

    public static class Factory implements com.codeHeap.reflectionAPI.rTTIisInstanceOf.petShop.Factory{
        @Override
        public Object create() {
            return new Mutt();
        }
    }
}
