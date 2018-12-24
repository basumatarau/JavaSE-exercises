package com.codeHeap.threads.CarBuilder;

public class EngineRobot extends Robot {
    public EngineRobot(RobotPool robotPool) {
        super(robotPool);
    }

    @Override
    protected void performService() {
        System.out.println(this + " is installing engine");
        assembler.getTheCar().addEngine();
    }
}
