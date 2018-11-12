package com.testProject.ReflectionAPI.RTTIisInstanceOf.RegisteredFactories;

public class AirFilter extends Filter{

    public static class Factory implements com.testProject.ReflectionAPI.RTTIisInstanceOf.RegisteredFactories.Factory {
        @Override
        public AirFilter create() {
            return new AirFilter();
        }
    }

}
