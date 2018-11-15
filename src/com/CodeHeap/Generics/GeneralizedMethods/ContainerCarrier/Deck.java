package com.CodeHeap.Generics.GeneralizedMethods.ContainerCarrier;

import java.util.ArrayList;

public class Deck extends ArrayList<Container> {
    public Deck(int containers, int cargoesPerContainer){
        for (int i = 0; i < containers; i++) {
            add(new Container(cargoesPerContainer));
        }
    }
}
