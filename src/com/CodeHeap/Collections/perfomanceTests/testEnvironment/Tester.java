package com.CodeHeap.Collections.perfomanceTests.testEnvironment;

import java.util.List;

public class Tester<C> {
    public static int fieldWidth = 8;
    public static TestParam[] defaultParams = TestParam.array(10, 5000, 100, 5000, 1000, 5000, 10000, 500);
    private String headline = "";
    public List<Test<C>> tests;

    protected C container;

    protected C initialize(int size) {
        return container;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    private static String stringField() {
        return "%" + fieldWidth + "s";
    }

    private static String numberField() {
        return "%" + fieldWidth + "d";
    }

    private static int sizeWidth = 5;
    private static String sizeField = "%" + sizeWidth + "s";
    private TestParam[] paramList = defaultParams;

    public void timedTest() {
        displayHeader();
        for (TestParam testParam : paramList) {
            System.out.print(String.format(sizeField, testParam.size));
            for (Test<C> test : tests) {
                C container = initialize(testParam.size);
                long start = System.nanoTime();
                int reps = test.test(container, testParam);
                long duration = System.nanoTime() - start;
                long timePerRep = duration / reps;
                System.out.print(String.format(numberField(), timePerRep));
            }
            System.out.println();
        }
    }

    private void displayHeader() {
        int width = fieldWidth * tests.size() + sizeWidth;
        int dashLength = width - headline.length() - 1;
        StringBuilder header = new StringBuilder(width);
        for (int i = 0; i < dashLength / 2; i++) {
            header.append('-');
        }
        header.append(' ').append(headline).append(' ');
        for (int i = 0; i < dashLength / 2; i++) {
            header.append('-');
        }
        System.out.println(header);
        System.out.print(String.format(sizeField, "size"));
        for (Test<C> test : tests) {
            System.out.print(String.format(stringField(), test.name));
        }
        System.out.println();
    }

    public static <C> void run(C container, List<Test<C>> tests, TestParam[] params) {
        new Tester<>(container, tests, params).timedTest();
    }

    public static <C> void run(C container, List<Test<C>> tests) {
        new Tester<>(container, tests).timedTest();
    }

    public Tester(C container, List<Test<C>> tests) {
        this.container = container;
        this.tests = tests;
        if (container != null) {
            this.headline = container.getClass().getSimpleName();
        }
    }

    public Tester(C container, List<Test<C>> tests, TestParam[] params) {
        this(container, tests);
        paramList = params;
    }

}
