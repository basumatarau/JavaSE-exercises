package com.CodeHeap.enums.doubleDispatch.RoShamBo2;

public interface Competitor<T extends Competitor<T>> {
    Outcome compete(T competitor);
}
