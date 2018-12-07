package com.codeHeap.reflectionAPI.rTTIisInstanceOf.registeredFactories;

public class FanBelt extends Part {
    public static class Factory implements com.codeHeap.reflectionAPI.rTTIisInstanceOf.registeredFactories.Factory{
        @Override
        public Object create() {
            return new FanBelt();
        }
    }
}
