package com.codeHeap.enums.doubleDispatch.roShamBo2;

public interface Competitor<T extends Competitor<T>> {
    Outcome compete(T competitor);
}
