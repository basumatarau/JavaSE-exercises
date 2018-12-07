package com.codeHeap.reflectionAPI.latentReflection.v5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeHeap.reflectionAPI.latentReflection.v5.Functional.*;

public class Runner {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 3, 5, 6, 7, 8, -9, -10, 11, 12));
        List<Integer> filtered1 = filter(numbers, new UnaryPredicate<Integer>() {
            @Override
            public boolean test(Integer obj) {
                return obj > 0;
            }
        });
        List<Integer> filtered2 = filter(numbers, (num) -> num > 0);
        System.out.println(filtered1);
        System.out.println(filtered2);

        Collector<Integer> collector = forEach(numbers, new Collector<Integer>() {
            private Integer result = 0;

            @Override
            public Integer collect() {
                return result;
            }

            @Override
            public Integer function(Integer obj) {
                result += obj;
                return result;
            }
        });
        System.out.println(collector.collect());

        List<Integer> transformed = transform(numbers, (item) -> item * 2);
        System.out.println(transformed);
        List<Integer> transformed2 = transform(numbers, new UnaryFunction<Integer, Integer>() {
            @Override
            public Integer function(Integer obj) {
                return obj * 2;
            }
        });
        System.out.println(transformed2);

        Integer reduced = reduce(numbers, new Combiner<Integer>() {
            @Override
            public Integer combine(Integer first, Integer second) {
                return first * second;
            }
        });
        System.out.println(reduced);
        Integer reduced2 = reduce(numbers, (num1, num2) -> num1 * num2);
        System.out.println(reduced2);
    }
}
