package com.codeHeap.collections.perfomanceTests;

import com.codeHeap.collections.perfomanceTests.testEnvironment.Test;
import com.codeHeap.collections.perfomanceTests.testEnvironment.TestParam;
import com.codeHeap.collections.perfomanceTests.testEnvironment.Tester;

import java.util.*;

public class MapPerformance {
    public static List<Test<Map<Integer, Integer>>> tests = new ArrayList<>();

    static {
        tests.add(new Test<Map<Integer, Integer>>("put") {
            @Override
            public int test(Map<Integer, Integer> container, TestParam param) {
                int loops = param.loops;
                int size = param.size;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    for (int j = 0; j < size; j++) {
                        container.put(i, j);
                    }
                }
                return loops * size;
            }
        });
        tests.add(new Test<Map<Integer, Integer>>("get") {
            @Override
            public int test(Map<Integer, Integer> container, TestParam param) {
                int loops = param.loops;
                int span = param.size * 2;
                for (int i = 0; i < loops; i++) {
                    for (int j = 0; j < span; j++) {
                        container.get(j);
                    }
                }
                return span * loops;
            }
        });
        tests.add(new Test<Map<Integer, Integer>>("iterate") {
            @Override
            public int test(Map<Integer, Integer> container, TestParam param) {
                int loops = param.loops;
                for (int i = 0; i < loops; i++) {
                    Iterator<Map.Entry<Integer, Integer>> iterator = container.entrySet().iterator();
                    while (iterator.hasNext()) {
                        iterator.next();
                    }
                }
                return loops * container.size()+1;
            }
        });
    }


    public static void main(String[] args) {
        Tester.run(new SlowMap<>(), tests);
        Tester.run(new TreeMap<>(), tests);
        Tester.run(new HashMap<>(), tests);
        Tester.run(new LinkedHashMap<>(), tests);
        Tester.run(new IdentityHashMap<>(), tests);
        Tester.run(new WeakHashMap<>(), tests);
        Tester.run(new Hashtable<>(), tests);
    }
}
