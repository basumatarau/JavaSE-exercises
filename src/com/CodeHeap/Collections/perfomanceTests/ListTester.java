package com.CodeHeap.Collections.perfomanceTests;

import com.CodeHeap.Collections.AbstractCollections.countingInteger.CountingInteger;
import com.CodeHeap.Collections.perfomanceTests.testEnvironment.Test;
import com.CodeHeap.Collections.perfomanceTests.testEnvironment.Tester;

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
