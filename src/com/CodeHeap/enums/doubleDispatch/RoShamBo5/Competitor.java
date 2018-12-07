package com.CodeHeap.enums.doubleDispatch.RoShamBo5;

public interface Competitor<T extends Competitor<T>> {
    Outcome compete(T competitor);
}
