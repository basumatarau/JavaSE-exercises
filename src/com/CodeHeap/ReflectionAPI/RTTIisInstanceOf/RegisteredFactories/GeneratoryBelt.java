package com.CodeHeap.ReflectionAPI.RTTIisInstanceOf.RegisteredFactories;

public class GeneratoryBelt extends Part {
    public static class Factory implements com.CodeHeap.ReflectionAPI.RTTIisInstanceOf.RegisteredFactories.Factory{
        @Override
        public GeneratoryBelt create() {
            return new GeneratoryBelt();
        }
    }
}
