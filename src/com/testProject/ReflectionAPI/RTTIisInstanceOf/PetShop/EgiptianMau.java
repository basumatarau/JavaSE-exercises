package com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop;

public class EgiptianMau extends Cat {
    public EgiptianMau(String name) {
        super(name);
    }

    public EgiptianMau() {
        super();
    }
    public static class Factory implements com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop.Factory{
        @Override
        public Object create() {
            return new EgiptianMau();
        }
    }

}
