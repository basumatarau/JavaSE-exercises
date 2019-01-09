package com.codeHeap.enums.simpleFinitAutomataV2;

import com.codeHeap.arrays.countingGenerator.Generator;

import java.util.EnumMap;

public class VendingMachine {

    private State state = State.RESTING;
    private int amount = 0;
    private Input selection = null;

    abstract class BasicState {
        void output(){
            System.out.println(amount);
        }
        void next(){
            throw new RuntimeException("next(Input input) has been called for non-transient instance");
        }
        void next(Input input){
            throw new RuntimeException("next(Input input) has been called for non-transient instance");
        }
    }

    enum StateDuration {TRANSIENT}

    enum State {
        RESTING, ADDING_MONEY, DISPENSING, GIVING_CHANGE(StateDuration.TRANSIENT), TERMINAL(StateDuration.TRANSIENT);
        boolean isTrnasitive = false;
        State(){}
        State(StateDuration trans){
            isTrnasitive = true;
        }
    }

    private EnumMap<State, BasicState> states = new EnumMap<>(State.class);

    {
        states.put(
                State.RESTING, new BasicState() {
                    @Override
                    public void next(Input input) {
                        if(input instanceof Coin) {
                            amount += input.amount();
                            state = State.ADDING_MONEY;
                        }
                        if(input instanceof ControlHandles){
                            if(((ControlHandles) input).getName().equals("Stop"))
                            state = State.TERMINAL;
                        }
                    }
                }
        );
        states.put(
                State.ADDING_MONEY, new BasicState() {
                    @Override
                    public void next(Input input) {
                        if(input instanceof Coin) {
                            amount += input.amount();
                        }
                        if(input instanceof Good) {
                            selection = input;
                            if (selection.value > amount) {
                                System.out.println("Insufficient money for " + selection);
                            } else {
                                state = State.DISPENSING;
                            }
                        }
                        if(input instanceof ControlHandles){
                            if(((ControlHandles) input).getName().equals("Abort_Transaction")){
                                state = State.GIVING_CHANGE;
                            }else{
                                state = State.TERMINAL;
                            }
                        }
                    }
                }
        );
        states.put(
                State.DISPENSING, new BasicState() {
                    @Override
                    public void next(Input input) {
                        System.out.println("here is your " + selection);
                        amount -= selection.amount();
                        state = State.GIVING_CHANGE;
                    }
                }
        );
        states.put(
                State.GIVING_CHANGE, new BasicState() {
                    @Override
                    public void next() {
                        if (amount > 0) {
                            System.out.println("here is your change: " + amount);
                            amount = 0;
                        }
                        state = State.RESTING;
                    }
                }
        );
        states.put(
                State.TERMINAL, new BasicState() {
                    @Override
                    public void output() {
                        System.out.println("Halted...");
                    }
                }
        );
    }

    public void run(Generator<Input> generator){
        while(state!=State.TERMINAL){
            states.get(state).next(generator.next());
            while(state.isTrnasitive){
                states.get(state).next();
            }
            states.get(state).output();
        }
    }


}
