package com.codeHeap.generics.basicBounds;

import java.util.ArrayList;
import java.util.List;

public class EpicBattle {
    static <POWER extends SuperHearing> void useSuperHearing(SuperHero<POWER> superHero){
        superHero.getPower().hearSubtleNoises();
    }

    static <POWER extends SuperSmell & SuperHearing> void useSuperFind(SuperHero<POWER> superHero){
        superHero.getPower().hearSubtleNoises();
        superHero.getPower().trackBySmell();
    }

    public static void main(String[] args) {
        DogBoy dogBoy = new DogBoy(new SuperHearSmell());
        useSuperHearing(dogBoy);
        useSuperFind(dogBoy);

        List<? extends SuperHearing> audioBoys = new ArrayList<>();

    }
}
