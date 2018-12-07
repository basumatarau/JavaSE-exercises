package com.codeHeap.enums.doubleDispatch.roShamBo2;
import static com.codeHeap.enums.doubleDispatch.roShamBo2.Outcome.*;

public enum RoShamBo2 implements Competitor<RoShamBo2> {
    PAPER(DRAW, LOOSE, WIN),
    SCISSORS(WIN, DRAW, LOOSE),
    ROCK(LOOSE, WIN, DRAW);

    Outcome againstPaper;
    Outcome againstScissors;
    Outcome againstRock;

    RoShamBo2(Outcome vsPaper, Outcome vsScissors, Outcome vsRock){
        againstPaper = vsPaper;
        againstScissors = vsScissors;
        againstRock = vsRock;
    }

    @Override
    public Outcome compete(RoShamBo2 competitor) {
        switch (competitor){
            case ROCK:
                return againstRock;
            case PAPER:
                return againstPaper;
            default:
                return againstScissors;
        }
    }

    public static void main(String[] args) {
        RoShamBoUtil.play( RoShamBo2.class, 20);
    }

}
