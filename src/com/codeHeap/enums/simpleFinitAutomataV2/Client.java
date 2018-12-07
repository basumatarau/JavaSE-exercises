package com.codeHeap.enums.simpleFinitAutomataV2;

public class Client {
    public static void main(String[] args) {
        //VendingMachine.run(Input::selectRandomInput);

        VendingMachine vm = new VendingMachine();
        vm.run(Input::selectRandomInput);
    }
}
