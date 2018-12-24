package com.codeHeap.threads.carBuilder;

public class WheelRobot extends Robot {
    WheelRobot(RobotPool robotPool) {
        super(robotPool);
    }

    @Override
    protected void performService() {
        System.out.println(this + " is installing wheels");
        assembler.getTheCar().addWheels();
    }
}
