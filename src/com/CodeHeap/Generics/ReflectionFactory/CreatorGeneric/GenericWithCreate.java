package com.CodeHeap.Generics.ReflectionFactory.CreatorGeneric;

public abstract class GenericWithCreate <T> {
    final T element;
    GenericWithCreate(){
        element = create();
    }
    abstract T create();
}
