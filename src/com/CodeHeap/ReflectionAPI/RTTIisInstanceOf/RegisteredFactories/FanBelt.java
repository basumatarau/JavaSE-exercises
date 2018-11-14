package com.CodeHeap.ReflectionAPI.RTTIisInstanceOf.RegisteredFactories;

public class FanBelt extends Part {
    public static class Factory implements com.CodeHeap.ReflectionAPI.RTTIisInstanceOf.RegisteredFactories.Factory{
        @Override
        public Object create() {
            return new FanBelt();
        }
    }
}
