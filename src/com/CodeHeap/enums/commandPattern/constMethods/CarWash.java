package com.CodeHeap.enums.commandPattern.constMethods;

import java.util.EnumSet;

public class CarWash {
    public enum Cycle{
        UNDERBODY{
            @Override
            void action() {
                System.out.println("Spraying underbody");
            }
        },
        WHEELWASH{
            @Override
            void action() {
                System.out.println("Washing wheels");
            }
        },
        PREWASH{
            @Override
            void action() {
                System.out.println("Loosening the dirt");
            }
        },
        BASIC{
            @Override
            void action() {
                System.out.println("The basic wash");
            }
        },
        HOTWAX{
            @Override
            void action() {
                System.out.println("Applying hot wax");
            }
        },
        RINSE {
            @Override
            void action() {
                System.out.println("Rinsing");
            }
        },
        BLOWDRY{
            @Override
            void action() {
                System.out.println("Blowing dry");
            }
        };

        abstract void action();
    }

    EnumSet<Cycle> cycles = EnumSet.of(Cycle.RINSE, Cycle.BASIC);

    public void add(Cycle cycle){
        cycles.add(cycle);
    }

    public void washCar(){
        for (Cycle cycle : cycles) {
            cycle.action();
        }
    }

    @Override
    public String toString() {
        return cycles.toString();
    }

    public static void main(String[] args) {
        CarWash carWash = new CarWash();
        System.out.println(carWash);
        carWash.washCar();

        carWash.add(Cycle.HOTWAX);
        carWash.add(Cycle.HOTWAX);
        carWash.add(Cycle.BLOWDRY);
        System.out.println(carWash);
        carWash.washCar();
    }
}
