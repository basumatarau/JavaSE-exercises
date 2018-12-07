package com.codeHeap.reflectionAPI.rTTIisInstanceOf.registeredFactories;

public class GeneratoryBelt extends Part {
    public static class Factory implements com.codeHeap.reflectionAPI.rTTIisInstanceOf.registeredFactories.Factory{
        @Override
        public GeneratoryBelt create() {
            return new GeneratoryBelt();
        }
    }
}
