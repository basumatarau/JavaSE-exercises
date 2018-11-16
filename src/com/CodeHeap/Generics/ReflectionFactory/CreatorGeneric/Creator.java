package com.CodeHeap.Generics.ReflectionFactory.CreatorGeneric;

public class Creator extends GenericWithCreate<SomeType>{
    @Override
    SomeType create() {
        return new SomeType();
    }
    public void nameYourself(){
        System.out.println(element.getClass().getSimpleName());
    }
}
