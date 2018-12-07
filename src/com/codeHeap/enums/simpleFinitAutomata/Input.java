package com.codeHeap.enums.simpleFinitAutomata;

import java.util.Random;

public enum Input {

    NICKEL(5), DIME(10), QUARTER(25), DOLLAR(100),
    TOOTHPASTE(100), CHIPS(75), SODA(100), SOAP(50),
    ABORT_TRANSACTION {
        @Override
        int amount() {
            throw new RuntimeException("ABORT_AMOUNT.amount();");
        }
    },
    STOP {
        @Override
        int amount() {
            throw new RuntimeException("STOP.amount();");
        }
    };

    int value;

    int amount() {
        return value;
    }

    Input() {
    }

    Input(int value) {
        this.value = value;
    }

    static Random random = new Random(47);

    public static Input selectRandomInput() {
        //not including STOP instance...
        return values()[random.nextInt(values().length - 1)];
    }
}
