package com.codeHeap.reflectionAPI.rTTIisInstanceOf.registeredFactories;

public class FuelFilter extends Filter{

    public static class Factory  implements com.codeHeap.reflectionAPI.rTTIisInstanceOf.registeredFactories.Factory  {
        @Override
        public FuelFilter create() {
            return new FuelFilter();
        }
    }

}
