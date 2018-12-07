package com.codeHeap.reflectionAPI.rTTIisInstanceOf.registeredFactories;

public class AirFilter extends Filter{

    public static class Factory implements com.codeHeap.reflectionAPI.rTTIisInstanceOf.registeredFactories.Factory {
        @Override
        public AirFilter create() {
            return new AirFilter();
        }
    }

}
