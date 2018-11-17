package com.CodeHeap.ReflectionAPI.RTTIisInstanceOf.PetShop;

public class Pet extends Individual {
    public Pet(){
        super();
    }
    Pet(String name){
        super(name);
    }

    public static class Factory implements com.CodeHeap.ReflectionAPI.RTTIisInstanceOf.PetShop.Factory{
        @Override
        public Object create() {
            return new Pet();
        }
    }
}
