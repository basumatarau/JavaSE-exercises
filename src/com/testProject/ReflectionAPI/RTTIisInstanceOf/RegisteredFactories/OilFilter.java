package com.testProject.ReflectionAPI.RTTIisInstanceOf.RegisteredFactories;

public class OilFilter extends Filter{

    public static class Factory implements com.testProject.ReflectionAPI.RTTIisInstanceOf.RegisteredFactories.Factory {
        @Override
        public OilFilter create() {
            return new OilFilter();
        }
    }

}
