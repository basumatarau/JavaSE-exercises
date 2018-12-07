package com.CodeHeap.enums.doubleDispatch.RoShamBo1;
import static com.CodeHeap.enums.doubleDispatch.RoShamBo1.Outcome.*;

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
