package com.codeHeap.enums.simpleFinitAutomata;

public class Client {
    public static void main(String[] args) {
        VendingMachine.run(Input::selectRandomInput);
    }
}
