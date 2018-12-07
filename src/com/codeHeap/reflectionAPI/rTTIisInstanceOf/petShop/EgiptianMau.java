package com.codeHeap.reflectionAPI.rTTIisInstanceOf.petShop;

public class EgiptianMau extends Cat {
    public EgiptianMau(String name) {
        super(name);
    }

    public EgiptianMau() {
        super();
    }
    public static class Factory implements com.codeHeap.reflectionAPI.rTTIisInstanceOf.petShop.Factory{
        @Override
        public Object create() {
            return new EgiptianMau();
        }
    }

}
