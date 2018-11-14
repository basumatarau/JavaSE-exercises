package com.CodeHeap.ReflectionAPI.RTTIisInstanceOf.PetShop;

public class Mutt extends Pet {
    public Mutt() {
        super();
    }

    public Mutt(String name) {
        super(name);
    }

    public static class Factory implements com.CodeHeap.ReflectionAPI.RTTIisInstanceOf.PetShop.Factory{
        @Override
        public Object create() {
            return new Mutt();
        }
    }
}
