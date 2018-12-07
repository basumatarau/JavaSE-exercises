package com.codeHeap.collections.perfomanceTests;

import com.codeHeap.collections.abstractCollections.countingInteger.CountingInteger;
import com.codeHeap.collections.perfomanceTests.testEnvironment.Test;
import com.codeHeap.collections.perfomanceTests.testEnvironment.Tester;

import java.util.List;

class ListTester extends Tester<List<Integer>> {

    public ListTester(List<Integer> container, List<Test<List<Integer>>> tests) {
        super(container, tests);
    }

    @Override
    protected List<Integer> initialize(int size) {
        container.clear();
        container.addAll(new CountingInteger(size));
        return container;
    }

    public static void run(List<Integer> list, List<Test<List<Integer>>> tests) {
        new ListTester(list, tests).timedTest();
    }
}
