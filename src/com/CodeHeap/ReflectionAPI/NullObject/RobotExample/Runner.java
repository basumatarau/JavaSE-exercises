package com.CodeHeap.ReflectionAPI.NullObject.RobotExample;

import java.lang.reflect.Proxy;

public class Runner {
    public static void main(String[] args) {
        SnowRemovalRobot valera = new SnowRemovalRobot("Valera");

        Robot[] bots = {
                valera,
                (Robot) Proxy.newProxyInstance(Robot.class.getClassLoader(),
                        new Class[]{Null.class, Robot.class},
                        new NullRobotProxyHandler(valera.getClass()))
        };

        for (Robot bot : bots) {
            Robot.Test.test(bot);
        }

    }
}
