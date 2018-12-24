package com.codeHeap.threads.carBuilder;

import java.util.HashSet;

class RobotPool {
    private HashSet<Robot> pool = new HashSet<>();

    synchronized void release(Robot r){
        pool.add(r);
        notifyAll();
    }

    synchronized void get(Class<? extends Robot> robotType,
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
        get(robotType, assembler);
    }
}
