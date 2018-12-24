package com.codeHeap.threads.CarBuilder;

public class DriveTrainRobot extends Robot {
    public DriveTrainRobot(RobotPool robotPool) {
        super(robotPool);
    }

    @Override
    protected void performService() {
        System.out.println(this + " is installing driveTrain");
        assembler.getTheCar().addDriveTrain();
    }
}
