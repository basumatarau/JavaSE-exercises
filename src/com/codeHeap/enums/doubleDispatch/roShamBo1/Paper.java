package com.codeHeap.enums.doubleDispatch.roShamBo1;
import static com.codeHeap.enums.doubleDispatch.roShamBo1.Outcome.*;

public class Paper extends Item {
    @Override
    public Outcome compete(Item item) {
        return item.eval(this);
    }

    @Override
    public Outcome eval(Paper paper) {
        return DRAW;
    }

    @Override
    public Outcome eval(Scissors scissors) {
        return WIN;
    }

    @Override
    public Outcome eval(Rock rock) {
        return LOOSE;
    }
}
