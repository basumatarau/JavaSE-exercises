package com.codeHeap.generics.generalizedMethods.containerCarrier;

import java.util.ArrayList;

public class Ship extends ArrayList<Deck> {

    private Anchor[] anchors;
    {
        this.anchors = new Anchor[]{
                new Anchor(),
                new Anchor(),
                new Anchor(),
                new Anchor()
        };
    }

    public Ship(int decks, int containersPerDeck, int cargoesPerContainer){
        for (int i = 0; i < decks; i++) {
            add(new Deck(containersPerDeck, cargoesPerContainer));
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Deck deck : this) {
            for (Container container : deck) {
                for (Cargo cargo : container) {
                    result.append(cargo).append('\n');
                }
            }
        }
        return result.toString();
    }
}
