package com.codeHeap.generics.reflectionFactory.creatorGeneric;

public abstract class GenericWithCreate <T> {
    final T element;
    GenericWithCreate(){
        element = create();
    }
    abstract T create();
}
