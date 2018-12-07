package com.codeHeap.reflectionAPI.rTTIisInstanceOf.petShop;

public class Cat extends Pet {
    public Cat() {
        super();
    }

    public Cat(String name) {
        super(name);
    }

    public static class Factory implements com.codeHeap.reflectionAPI.rTTIisInstanceOf.petShop.Factory{
        @Override
        public Object create() {
            return new Cat();
        }
    }
}
