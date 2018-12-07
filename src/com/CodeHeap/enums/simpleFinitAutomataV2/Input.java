package com.CodeHeap.enums.simpleFinitAutomataV2;

import java.util.ArrayList;
import java.util.Random;

public abstract class Input {

    private static ArrayList<Input> inputs = new ArrayList<>();

    //thread unsafe implementation (class loader for Input and its subclasses may get into a deadlock...)
    static {
        inputs.add(new Coin("Nickel", 5));
        inputs.add(new Coin("Dime", 10));
        inputs.add(new Coin("Quarter", 25));
        inputs.add(new Coin("Dollar", 100));

        inputs.add(new Good("Toothpaste", 100));
        inputs.add(new Good("Chips", 75));
        inputs.add(new Good("Soda", 100));
        inputs.add(new Good("Soap", 50));

        inputs.add(new ControlHandles("Abort_Transaction"));
        inputs.add(new ControlHandles("Stop"));
    }


    int value;

    int amount() {
        return value;
    }

    Input() {
    }

    Input(int value) {
        this.value = value;
    }

    private static Random random = new Random(47);

    static Input selectRandomInput() {
        //not including STOP instance...
        // so the TERMINAL state on random Item selection won't be achieved
        return inputs.subList(0, inputs.size()-1).get(random.nextInt(inputs.size()-1));
    }
}
