package com.codeHeap.reflectionAPI.latentReflection.v3;

import java.util.ArrayList;
import java.util.List;

public class Teletranfer extends Contract {
    public static void main(String[] args) {
        List<Contract> contracts = new ArrayList<>();
        Fill.fill(contracts, Contract.class, 5);
        Fill.fill(contracts, Teletranfer.class, 3);

        for (Contract contract : contracts) {
            System.out.println(contract);
        }
    }
}
