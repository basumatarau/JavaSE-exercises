package com.CodeHeap.Collections.perfomanceTests;

import com.CodeHeap.Collections.AbstractCollections.countingInteger.CountingInteger;
import com.CodeHeap.Collections.perfomanceTests.testEnvironment.Test;
import com.CodeHeap.Collections.perfomanceTests.testEnvironment.TestParam;
import com.CodeHeap.Collections.perfomanceTests.testEnvironment.Tester;
import com.CodeHeap.arrays.CountingGenerator.CountingGenerator;
import com.CodeHeap.arrays.CountingGenerator.Generated;
import com.CodeHeap.arrays.CountingGenerator.RandomGenerator;

import java.util.*;
import java.util.stream.Collectors;

public class ListPerformance {
    static Random rand = new Random();
    static int reps = 1000;
    static List<Test<List<Integer>>> tests = new ArrayList<>();
    static List<Test<LinkedList<Integer>>> qtests = new ArrayList<>();

    static {
        tests.add(new Test<List<Integer>>("add") {
            @Override
            public int test(List<Integer> container, TestParam param) {
                int loops = param.loops;
                int listSize = param.size;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    for (int j = 0; j < listSize; j++) {
                        container.add(j);
                    }
                }
                return loops * listSize;
            }
        });
        tests.add(new Test<List<Integer>>("get") {
            @Override
            public int test(List<Integer> container, TestParam param) {
                int loops = param.loops * reps;
                int listSize = container.size();
                for (int i = 0; i < loops; i++) {
                    container.get(rand.nextInt(listSize));
                }
                return loops;
            }
        });
        tests.add(new Test<List<Integer>>("set") {
            @Override
            public int test(List<Integer> container, TestParam param) {
                int loops = param.loops * reps;
                int listSize = container.size();
                for (int i = 0; i < loops; i++) {
                    container.set(rand.nextInt(listSize), 47);
                }
                return loops;
            }
        });
        tests.add(new Test<List<Integer>>("iteradd") {
            @Override
            public int test(List<Integer> container, TestParam param) {
                final int LOOPS = 1000000;
                int middlePos = container.size() / 2;
                ListIterator<Integer> integerListIterator = container.listIterator(middlePos);
                for (int i = 0; i < LOOPS; i++) {
                    integerListIterator.add(47);
                }
                return LOOPS;
            }
        });
        tests.add(new Test<List<Integer>>("insert") {
            @Override
            public int test(List<Integer> container, TestParam param) {
                int loops = param.loops;
                for (int i = 0; i < loops; i++) {
                    container.add(5, 47);
                }
                return loops;
            }
        });
        tests.add(new Test<List<Integer>>("remove") {
            @Override
            public int test(List<Integer> container, TestParam param) {
                int loops = param.loops;
                int size = param.size;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    container.addAll(new CountingInteger(size));
                }
                return size * loops;
            }
        });
        tests.add(new Test<List<Integer>>("sort"){
            @Override
            public int test(List<Integer> container, TestParam param) {
                int size = param.size;
                int loops = param.loops;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    container.addAll(Arrays.asList(Generated.fill(Integer.class, new RandomGenerator.Integer(), size)));
                    Collections.sort(container);
                }
                return loops;
            }
        });

        qtests.add(new Test<LinkedList<Integer>>("addFirst") {
            @Override
            public int test(LinkedList<Integer> container, TestParam param) {
                int size = param.size;
                int loops = param.loops;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    for (int j = 0; j < size; j++) {
                        container.addFirst(j);
                    }
                }
                return size * loops;
            }
        });
        qtests.add(new Test<LinkedList<Integer>>("addLast"){
            @Override
            public int test(LinkedList<Integer> container, TestParam param) {
                int size = param.size;
                int loops = param.loops;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    for (int j = 0; j < size; j++) {
                        container.addLast(j);
                    }
                }
                return size * loops;
            }
        });

        qtests.add(new Test<LinkedList<Integer>>("rmFirst"){
            @Override
            public int test(LinkedList<Integer> container, TestParam param) {
                int size = param.size;
                int loops = param.loops;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    container.addAll(new CountingInteger(size));
                    for (int j = 0; j < size; j++) {
                        container.removeFirst();
                    }
                }
                return size * loops;
            }
        });

        qtests.add(new Test<LinkedList<Integer>>("rmLast"){
            @Override
            public int test(LinkedList<Integer> container, TestParam param) {
                int size = param.size;
                int loops = param.loops;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    container.addAll(new CountingInteger(size));
                    for (int j = 0; j < size; j++) {
                        container.removeLast();
                    }
                }
                return size * loops;
            }
        });
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            Tester.defaultParams = TestParam.array(args);
        }

        Tester<List<Integer>> arrayTest = new Tester<List<Integer>>(null, tests.subList(1, 3)) {
            @Override
            protected List<Integer> initialize(int size) {
                Integer[] ia = Generated.fill(Integer.class, new CountingGenerator.Integer(), size);
                return Arrays.asList(ia);
            }
        };
        arrayTest.setHeadline("Array as List");
        arrayTest.timedTest();
        ListTester.run(new ArrayList<>(), tests);
        ListTester.run(new LinkedList<>(), tests);
        Tester.fieldWidh = 12;
        Tester<LinkedList<Integer>> linkedListTester = new Tester<>(new LinkedList<Integer>(), qtests);
        linkedListTester.setHeadline("Queue tests");
        linkedListTester.timedTest();
    }
}
