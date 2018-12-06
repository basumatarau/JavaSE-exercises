package com.CodeHeap.enums.commandPattern.enumMaps;

import java.util.EnumMap;
import java.util.Map;

public class EnumMaps {
    public static void main(String[] args) {
        EnumMap<AlarmPoints, Command> alarmInstructions = new EnumMap<>(AlarmPoints.class);
        alarmInstructions.put(
                AlarmPoints.STAIR1, new Command() {
                    @Override
                    public void action() {
                        System.out.println("stair1 on fire");
                    }
                }
        );
        alarmInstructions.put(
                AlarmPoints.KITCHEN, new Command() {
                    @Override
                    public void action() {
                        System.out.println("Kitchen on fire");
                    }
                }
        );
        alarmInstructions.put(
                AlarmPoints.BATHROOM, () -> System.out.println("Bathroom on fire")
        );

        //alarm test
        for (Map.Entry<AlarmPoints, Command> entry : alarmInstructions.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().action();
        }
    }
}
