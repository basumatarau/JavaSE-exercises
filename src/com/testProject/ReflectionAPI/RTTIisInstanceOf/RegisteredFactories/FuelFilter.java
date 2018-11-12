package com.testProject.ReflectionAPI.RTTIisInstanceOf.RegisteredFactories;

public class FuelFilter extends Filter{

    public static class Factory  implements com.testProject.ReflectionAPI.RTTIisInstanceOf.RegisteredFactories.Factory  {
        @Override
        public FuelFilter create() {
            return new FuelFilter();
        }
    }

}
