package com.CodeHeap.ReflectionAPI.RTTIisInstanceOf.RegisteredFactories;

public class OilFilter extends Filter{

    public static class Factory implements com.CodeHeap.ReflectionAPI.RTTIisInstanceOf.RegisteredFactories.Factory {
        @Override
        public OilFilter create() {
            return new OilFilter();
        }
    }

}
