package com.CodeHeap.Generics.generalizedExceptions;

import java.util.List;

public interface Processor<T, Ex1 extends Exception, Ex2 extends Exception> {
    public void process(List<T> resultCollector) throws Ex1, Ex2;
}
