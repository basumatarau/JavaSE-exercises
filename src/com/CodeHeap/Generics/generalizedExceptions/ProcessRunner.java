package com.CodeHeap.Generics.generalizedExceptions;

import java.util.ArrayList;
import java.util.List;

public class ProcessRunner<T, E extends Exception> extends ArrayList<Processor<T, E>> {
    public List<T> processAll() throws E{
        List<T> results = new ArrayList<>();
        for (Processor<T, E> processor : this) {
            processor.process(results);
        }
        return results;
    }
}
