package com.codeHeap.enums.doubleDispatch.roShamBo5;

public interface Competitor<T extends Competitor<T>> {
    Outcome compete(T competitor);
}
