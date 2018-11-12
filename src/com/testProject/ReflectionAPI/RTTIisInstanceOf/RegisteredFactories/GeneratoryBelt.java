package com.testProject.ReflectionAPI.RTTIisInstanceOf.RegisteredFactories;

public class GeneratoryBelt extends Part {
    public static class Factory implements com.testProject.ReflectionAPI.RTTIisInstanceOf.RegisteredFactories.Factory{
        @Override
        public GeneratoryBelt create() {
            return new GeneratoryBelt();
        }
    }
}
