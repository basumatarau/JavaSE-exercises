package com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop;

import java.util.ArrayList;
import java.util.List;

public class LiteralPetCreator extends PetCreator {

    public static final List<Factory<? extends Pet>> allFactories =
            new ArrayList<>();

    static {
        //allFactories.add(new Individual.Factory());
        //allFactories.add(new Person.Factory());
        allFactories.add(new Pet.Factory());
        allFactories.add(new Rodent.Factory());
        allFactories.add(new Cat.Factory());
        allFactories.add(new Dog.Factory());
        allFactories.add(new EgiptianMau.Factory());
        allFactories.add(new Hamster.Factory());
        allFactories.add(new Mouse.Factory());
        allFactories.add(new Mutt.Factory());
        allFactories.add(new Pug.Factory());
        allFactories.add(new Rat.Factory());
    }

    public static final List<Factory<? extends Pet>> factories = allFactories.subList(
            2, allFactories.size()
    );

    @Override
    public List<Factory<? extends Pet>> register() {
        return factories;
    }

    public static void main(String[] args) {
        System.out.println(factories);
    }
}
