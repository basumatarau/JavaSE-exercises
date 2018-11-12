package com.testProject.ReflectionAPI.RTTIisInstanceOf.RegisteredFactories;

public class FanBelt extends Part {
    public static class Factory implements com.testProject.ReflectionAPI.RTTIisInstanceOf.RegisteredFactories.Factory{
        @Override
        public Object create() {
            return new FanBelt();
        }
    }
}
