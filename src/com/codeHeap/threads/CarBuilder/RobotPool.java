package com.codeHeap.threads.CarBuilder;

import java.util.HashSet;

public class RobotPool {
    private HashSet<Robot> pool = new HashSet<>();

    synchronized public void add(Robot r){
        pool.add(r);
        notifyAll();
    }

    synchronized public void hire(Class<? extends Robot> robotType,
            Assembler assembler) throws InterruptedException{

        for (Robot robot : pool) {
            if(robot.getClass().equals(robotType)){
                pool.remove(robot);
                robot.assignAssembler(assembler);
                robot.setEngaged();
                return;
            }
        }
        wait();
        hire(robotType, assembler);
    }
}
