package com.codeHeap.threads.carBuilder;

public class DriveTrainRobot extends Robot {
    DriveTrainRobot(RobotPool robotPool) {
        super(robotPool);
    }

    @Override
    protected void performService() {
        System.out.println(this + " is installing driveTrain");
        assembler.getTheCar().addDriveTrain();
    }
}
