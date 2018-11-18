package com.CodeHeap.Generics.generalizedExceptions;

import java.util.List;

public interface Processor<T, E extends Exception> {
    public void process(List<T> resultCollector) throws E;
}
