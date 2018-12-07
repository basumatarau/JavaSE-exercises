package com.codeHeap.reflectionAPI.rTTIisInstanceOf.registeredFactories;

public class OilFilter extends Filter{

    public static class Factory implements com.codeHeap.reflectionAPI.rTTIisInstanceOf.registeredFactories.Factory {
        @Override
        public OilFilter create() {
            return new OilFilter();
        }
    }

}
