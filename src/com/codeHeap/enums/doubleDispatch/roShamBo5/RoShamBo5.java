package com.codeHeap.enums.doubleDispatch.roShamBo5;

import java.util.EnumMap;
import static com.codeHeap.enums.doubleDispatch.roShamBo5.Outcome.*;

public enum RoShamBo5 implements Competitor<RoShamBo5>{
    PAPER, SCISSORS, ROCK;

    static EnumMap<RoShamBo5, EnumMap<RoShamBo5, Outcome>> table =
            new EnumMap<>(RoShamBo5.class);

    static {
        for (RoShamBo5 value : values()) {
            table.put(value, new EnumMap<>(RoShamBo5.class));
        }
            initRow(PAPER, DRAW, LOOSE, WIN);
            initRow(SCISSORS, WIN, DRAW, LOOSE);
            initRow(ROCK, LOOSE, WIN, DRAW);
    }

    private static void initRow(RoShamBo5 instance,
                                Outcome vsPaper,
                                Outcome vsScissors,
                                Outcome vsRock){

        EnumMap<RoShamBo5, Outcome> tableRow = table.get(instance);
        tableRow.put(PAPER, vsPaper);
        tableRow.put(SCISSORS, vsScissors);
        tableRow.put(ROCK, vsRock);
    }

    @Override
    public Outcome compete(RoShamBo5 competitor) {
        return table.get(this).get(competitor);
    }

    public static void main(String[] args) {
        RoShamBoUtil.play(RoShamBo5.class, 20);
    }

}
