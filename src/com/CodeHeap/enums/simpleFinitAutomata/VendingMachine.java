package com.CodeHeap.enums.simpleFinitAutomata;

import com.CodeHeap.arrays.CountingGenerator.Generator;

public class VendingMachine {

    private static State state = State.RESTING;
    private static int amount = 0;
    private static Input selection = null;

    enum StateDuration {TRANSIENT}

    enum State {
        RESTING {
            @Override
            public void next(Input input) {
                switch (Category.categorise(input)) {
                    case MONEY:
                        amount += input.amount();
                        state = State.ADDING_MONEY;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                }
            }
        },
        ADDING_MONEY {
            @Override
            public void next(Input input) {
                switch (Category.categorise(input)) {
                    case MONEY:
                        amount += input.amount();
                        break;
                    case ITEM_SELECTION:
                        selection = input;
                        if (selection.value > amount) {
                            System.out.println("Insufficient money for " + selection);
                        } else {
                            state = State.DISPENSING;
                        }
                        break;
                    case QUIT_TRANSACTION:
                        state = GIVING_CHANGE;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                }
            }
        },
        DISPENSING(StateDuration.TRANSIENT) {
            @Override
            public void next() {
                System.out.println("here is your " + selection);
                amount -= selection.amount();
                state = State.GIVING_CHANGE;
            }
        },
        GIVING_CHANGE(StateDuration.TRANSIENT) {
            @Override
            public void next() {
                if (amount > 0) {
                    System.out.println("here is your change: " + amount);
                    amount = 0;
                }
                state = State.RESTING;
            }
        },
        TERMINAL {
            @Override
            public void output() {
                System.out.println("Halted...");
            }
        };

        private boolean isTransient = false;

        State() {
        }

        State(StateDuration trans) {
            isTransient = true;
        }

        public void output() {
            System.out.println(amount);
        }

        public void next() {
            throw new RuntimeException("next(Input input) has been called for non-transient instance");
        }

        public void next(Input input) {
            throw new RuntimeException("next() has been called for transient instance");
        }
    }

    public static void run(Generator<Input> generator) {
        while (state != State.TERMINAL) {
            state.next(generator.next());
            while (state.isTransient) {
                state.next();
            }
            state.output();
        }
    }
}
