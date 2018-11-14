package com.CodeHeap.ReflectionAPI.RTTIisInstanceOf.RegisteredFactories;

public class CabinAirFilter extends Filter{

    public static class Factory implements com.CodeHeap.ReflectionAPI.RTTIisInstanceOf.RegisteredFactories.Factory {
        @Override
        public CabinAirFilter create() {
            return new CabinAirFilter();
        }
    }

}
