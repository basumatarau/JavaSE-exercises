package com.CodeHeap.Generics.generalizedExceptions;

import java.util.List;

public class Processor2 implements Processor<Integer, Failure2> {
    private static int count = 2;

    @Override
    public void process(List<Integer> resultCollector) throws Failure2 {
        if (count-- == 0) {
            resultCollector.add(11);
        } else {
            resultCollector.add(47);
        }
        if (count < 0) {
            throw new Failure2();
        }
    }
}
