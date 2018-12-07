package com.codeHeap.enums.doubleDispatch.roShamBo1;
import static com.codeHeap.enums.doubleDispatch.roShamBo1.Outcome.*;
public class Scissors extends Item {
    @Override
    public Outcome compete(Item item) {
        return item.eval(this);
    }

    @Override
    public Outcome eval(Paper paper) {
        return LOOSE;
    }

    @Override
    public Outcome eval(Scissors scissors) {
        return DRAW;
    }

    @Override
    public Outcome eval(Rock rock) {
        return WIN;
    }
}
