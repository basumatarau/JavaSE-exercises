package com.testProject.ReflectionAPI.RTTIisInstanceOf.RegisteredFactories;

public class CabinAirFilter extends Filter{

    public static class Factory implements com.testProject.ReflectionAPI.RTTIisInstanceOf.RegisteredFactories.Factory {
        @Override
        public CabinAirFilter create() {
            return new CabinAirFilter();
        }
    }

}
