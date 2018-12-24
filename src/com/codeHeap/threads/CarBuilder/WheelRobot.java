package com.codeHeap.threads.CarBuilder;

public class WheelRobot extends Robot {
    public WheelRobot(RobotPool robotPool) {
        super(robotPool);
    }

    @Override
    protected void performService() {
        System.out.println(this + " is installing wheels");
        assembler.getTheCar().addWheels();
    }
}
