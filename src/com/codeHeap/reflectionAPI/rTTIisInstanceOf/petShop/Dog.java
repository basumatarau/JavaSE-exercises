package com.codeHeap.reflectionAPI.rTTIisInstanceOf.petShop;

public class Dog extends Pet {
    public Dog() {
        super();
    }

    public Dog(String name) {
        super(name);
    }
    public static class Factory implements com.codeHeap.reflectionAPI.rTTIisInstanceOf.petShop.Factory{
        @Override
        public Object create() {
            return new Dog();
        }
    }
}
