package com.codeHeap.reflectionAPI.rTTIisInstanceOf.petShop;

public class Mouse extends Rodent {
    public Mouse() {
        super();
    }

    public Mouse(String name) {
        super(name);
    }
    public static class Factory implements com.codeHeap.reflectionAPI.rTTIisInstanceOf.petShop.Factory{
        @Override
        public Object create() {
            return new Mouse();
        }
    }
}
