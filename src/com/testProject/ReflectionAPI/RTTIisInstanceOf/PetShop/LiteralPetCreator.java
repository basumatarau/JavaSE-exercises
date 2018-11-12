package com.testProject.ReflectionAPI.RTTIisInstanceOf.PetShop;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LiteralPetCreator extends PetCreator{

    public static final List<Class<? extends Pet>> allTypes = Collections.unmodifiableList(
            Arrays.asList(Pet.class, Rodent.class, Cat.class, Dog.class, EgiptianMau.class,
                    Hamster.class, Mouse.class, Mutt.class, Pug.class, Rat.class)
    );

    public static final List<Class<? extends Pet>> types = allTypes.subList(allTypes.indexOf(Cat.class),
            allTypes.size());

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }

    public static void main(String[] args) {
        System.out.println(types);
    }
}
