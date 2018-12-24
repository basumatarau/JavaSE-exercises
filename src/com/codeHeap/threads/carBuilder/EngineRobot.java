package com.codeHeap.threads.carBuilder;

public class EngineRobot extends Robot {
    EngineRobot(RobotPool robotPool) {
        super(robotPool);
    }

    @Override
    protected void performService() {
        System.out.println(this + " is installing engine");
        assembler.getTheCar().addEngine();
    }
}
