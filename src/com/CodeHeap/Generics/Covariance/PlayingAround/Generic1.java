package com.CodeHeap.Generics.Covariance.PlayingAround;

public class Generic1<T> {
    private T instance;

    public void setInstance(T instance){
        this.instance = instance;
    }
    public T getInstance(){
        return instance;
    }
}
