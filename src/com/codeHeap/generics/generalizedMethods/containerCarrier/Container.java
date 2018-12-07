package com.codeHeap.generics.generalizedMethods.containerCarrier;

import com.codeHeap.generics.generalizedMethods.Generators;

import java.util.ArrayList;

public class Container extends ArrayList<Cargo> {
    public Container(int cargoes){
        Generators.fill(Cargo.getGenerator(), this, cargoes);
    }
}
