package com.CodeHeap.ReflectionAPI.RTTIisInstanceOf.PetShop;

public class Pug extends Pet {
    public Pug() {
        super();
    }

    public Pug(String name) {
        super(name);
    }
    public static class Factory implements com.CodeHeap.ReflectionAPI.RTTIisInstanceOf.PetShop.Factory{
        @Override
        public Object create() {
            return new Pug();
        }
    }
}
