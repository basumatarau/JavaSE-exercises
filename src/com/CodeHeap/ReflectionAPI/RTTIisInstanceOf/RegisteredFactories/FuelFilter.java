package com.CodeHeap.ReflectionAPI.RTTIisInstanceOf.RegisteredFactories;

public class FuelFilter extends Filter{

    public static class Factory  implements com.CodeHeap.ReflectionAPI.RTTIisInstanceOf.RegisteredFactories.Factory  {
        @Override
        public FuelFilter create() {
            return new FuelFilter();
        }
    }

}
