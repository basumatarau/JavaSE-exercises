package com.CodeHeap.ReflectionAPI.NullObject.RobotExample;

import java.util.Arrays;
import java.util.List;

public class SnowRemovalRobot implements Robot{
    private String name;
    private final String MODEL = "SnowBot Series 11";
    public SnowRemovalRobot(String name){
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String model() {
        return MODEL;
    }

    @Override
    public List<IOperation> operations() {
        return Arrays.asList(
                new IOperation() {
                    @Override
                    public String description() {
                        return name+" can shovel snow";
                    }

                    @Override
                    public void command() {
                        System.out.println(name + " is shoveling snow");
                    }
                },
                new IOperation() {
                    @Override
                    public String description() {
                        return name + " can chip ice";
                    }

                    @Override
                    public void command() {
                        System.out.println(name + " is chipping ice");
                    }
                },
                new IOperation(){
                    @Override
                    public String description() {
                        return name+" can clear the roof";
                    }

                    @Override
                    public void command() {
                        System.out.println(name+ " is cleaning the roof");
                    }
                }
        );
    }
}
