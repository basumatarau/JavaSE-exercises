package com.codeHeap.reflectionAPI.rTTIisInstanceOf.registeredFactories;

public class CabinAirFilter extends Filter{

    public static class Factory implements com.codeHeap.reflectionAPI.rTTIisInstanceOf.registeredFactories.Factory {
        @Override
        public CabinAirFilter create() {
            return new CabinAirFilter();
        }
    }

}
