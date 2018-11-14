package com.CodeHeap.ReflectionAPI.RTTIisInstanceOf.RegisteredFactories;

public class AirFilter extends Filter{

    public static class Factory implements com.CodeHeap.ReflectionAPI.RTTIisInstanceOf.RegisteredFactories.Factory {
        @Override
        public AirFilter create() {
            return new AirFilter();
        }
    }

}
