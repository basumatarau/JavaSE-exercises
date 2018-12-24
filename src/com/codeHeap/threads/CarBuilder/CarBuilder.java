package com.codeHeap.threads.CarBuilder;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CarBuilder {
    public static void main(String[] args) throws IOException {
        CarQueue chassis = new CarQueue();
        CarQueue finishingQueue = new CarQueue();

        ExecutorService executorService = Executors.newCachedThreadPool();
        RobotPool robotPool = new RobotPool();

        executorService.execute(new EngineRobot(robotPool));
        executorService.execute(new DriveTrainRobot(robotPool));
        executorService.execute(new WheelRobot(robotPool));

        executorService.execute(new Assembler(chassis, finishingQueue, robotPool));
        executorService.execute(new Reporter(finishingQueue));
        executorService.execute(new ChassisBuilder(chassis));

        System.in.read();
        executorService.shutdownNow();
    }
}
