package com.codeHeap.generics.generalizedExceptions;

import java.util.ArrayList;
import java.util.List;

public class ProcessRunner<T, Ex1 extends Exception, Ex2 extends Exception> extends ArrayList<Processor<T, Ex1, Ex2>> {
    public List<T> processAll() throws Ex1, Ex2{
        List<T> results = new ArrayList<>();
        for (Processor<T, Ex1, Ex2> processor : this) {
            processor.process(results);
        }
        return results;
    }
}
