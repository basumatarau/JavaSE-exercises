package com.codeHeap.enums.doubleDispatch.roShamBo1;

public abstract class Item {
    public abstract Outcome compete(Item item);
    public abstract Outcome eval (Paper paper);
    public abstract Outcome eval (Scissors scissors);
    public abstract Outcome eval (Rock rock);

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
