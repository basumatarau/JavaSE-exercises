package com.codeHeap.reflectionAPI.rTTIisInstanceOf.petShop;

public class Pug extends Pet {
    public Pug() {
        super();
    }

    public Pug(String name) {
        super(name);
    }
    public static class Factory implements com.codeHeap.reflectionAPI.rTTIisInstanceOf.petShop.Factory{
        @Override
        public Object create() {
            return new Pug();
        }
    }
}
