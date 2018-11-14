package com.CodeHeap.ReflectionAPI.RTTIisInstanceOf.PetShop;

public class Mouse extends Rodent {
    public Mouse() {
        super();
    }

    public Mouse(String name) {
        super(name);
    }
    public static class Factory implements com.CodeHeap.ReflectionAPI.RTTIisInstanceOf.PetShop.Factory{
        @Override
        public Object create() {
            return new Mouse();
        }
    }
}
