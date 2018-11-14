package com.CodeHeap.ReflectionAPI.NullObject.RobotExample;

import java.util.List;

public interface Robot {
    String name();
    String model();
    List<IOperation> operations();

    class Test{
        public static void test(Robot r){
            if(r instanceof Null){
                System.out.println("Null robot");
            }
            System.out.println("Robot name: "+r.name());
            System.out.println("Robot model: "+ r.model());
            for (IOperation operation : r.operations()) {
                System.out.println(operation.description());
                operation.command();
            }
        }
    }
}
