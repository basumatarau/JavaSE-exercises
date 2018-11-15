package com.CodeHeap.Generics.GeneralizedMethods.ContainerCarrier;

import com.CodeHeap.Generics.GeneralizedMethods.Generators;

import java.util.ArrayList;

public class Container extends ArrayList<Cargo> {
    public Container(int cargoes){
        Generators.fill(Cargo.getGenerator(), this, cargoes);
    }
}
