package com.codeHeap.threads.greenHouseDelayQueue;

import java.util.*;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class GreenHouseScheduler {
    private volatile boolean light = false;
    private volatile boolean water = false;
    private String thermostat = "night";

    synchronized public String getThermostat() {
        return thermostat;
    }

    synchronized public void setThermostat(String thermostat) {
        this.thermostat = thermostat;
    }

    private DelayQueue<Task> queue = new DelayQueue<>();

    private class Task implements Delayed{
        private Runnable task;
        private int delay;
        long trigger;

        public long getTrigger(){
            return trigger;
        }

        public Runnable getTask(){
            return task;
        }

        Task(Runnable event, int delayTime) {
            task = event;
            delay = delayTime;
            trigger = System.nanoTime() + TimeUnit.NANOSECONDS.convert(delayTime, TimeUnit.MILLISECONDS);
        }

        @Override
        public long getDelay(TimeUnit timeUnit) {
            return timeUnit.convert(trigger - System.nanoTime(), TimeUnit.NANOSECONDS);
        }

        @Override
        public int compareTo(Delayed delayed) {
            if (trigger > ((Task) delayed).getTrigger())
                return 1;
            if(trigger < ((Task) delayed).getTrigger())
                return -1;
            return 0;
        }
    }

    public void schedule(Runnable event, int delayTime) {
        Task task = new Task(event, delayTime);
        queue.add(task);
        //scheduler.schedule(event, delayTime, TimeUnit.MILLISECONDS);
    }

    public void repeat(Runnable event, int delayTime, long cycleLength) {
        Task task = new Task(event, delayTime);
        queue.add(task);

        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    while (true) {
                        TimeUnit.MILLISECONDS.sleep(cycleLength);
                        queue.add(new Task(event, delayTime));
                    }
                }catch (InterruptedException e){
                    System.out.println("interrupted");
                }
            }
        };
        thread.setDaemon(true);
        thread.start();

        //scheduler.scheduleAtFixedRate(event, delayTime, cycleLength, TimeUnit.MILLISECONDS);
    }

    public class LightOn implements Runnable {
        @Override
        public void run() {
            light = true;
            System.out.println("lights on");
        }
    }

    public class LightOff implements Runnable {
        @Override
        public void run() {
            light = false;
            System.out.println("lights off");
        }
    }

    public class WaterOn implements Runnable {
        @Override
        public void run() {
            water = true;
            System.out.println("water on");
        }
    }

    public class WaterOff implements Runnable {
        @Override
        public void run() {
            water = false;
            System.out.println("water off");
        }
    }

    public class ThermostatDay implements Runnable {
        @Override
        public void run() {
            setThermostat("day");
        }
    }

    public class ThermostatNight implements Runnable {
        @Override
        public void run() {
            setThermostat("night");
        }
    }

    public class Bell implements Runnable {
        @Override
        public void run() {
            System.out.println("Bell is ringing...");
        }
    }

    public class Terminate implements Runnable {

        @Override
        public void run() {

            System.out.println("system is shutting down");
            //scheduler.shutdownNow();
            queue.clear();

            new Thread() {
                @Override
                public void run() {
                    System.out.println("here goers the dump....");
                    for (DataPoint datum : data) {
                        System.out.println(datum);
                    }
                }
            }.run();

        }
    }

    public void run(){
        try {
            while (!queue.isEmpty()) {
                queue.take().getTask().run();
            }
        }catch (InterruptedException e){
            System.out.println("interrupted");
        }
    }

    static class DataPoint {
        final Calendar time;
        final float temperature;
        final float humidity;

        public DataPoint(Calendar calendar, float humidity, float temperature) {
            this.time = calendar;
            this.humidity = humidity;
            this.temperature = temperature;
        }

        @Override
        public String toString() {
            return time.getTime() + String.format(" temperature: %1$.1f, humidity: %2$.2f", temperature, humidity);
        }
    }

    private Calendar lastTime = Calendar.getInstance();

    {
        lastTime.set(Calendar.MINUTE, 30);
        lastTime.set(Calendar.SECOND, 0);
    }

    private float lastTempMeasurement = 65.0f;
    private int temDirection = -1;
    private float lastHumidityMeasurement = 50.0f;
    private int humDierction = 1;
    private Random rand = new Random(47);
    List<DataPoint> data = Collections.synchronizedList(new ArrayList<>());

    class CollectData implements Runnable {
        @Override
        public void run() {
            System.out.println("collecting data...");
            synchronized (GreenHouseScheduler.this) {
                lastTime.set(Calendar.MINUTE, lastTime.get(Calendar.MINUTE) + 30);

                if (rand.nextInt(5) == 4) {
                    temDirection = -temDirection;
                }
                lastTempMeasurement += temDirection * (1.0f + rand.nextFloat());

                if (rand.nextInt(5) == 4) {
                    humDierction = -humDierction;
                }
                lastHumidityMeasurement += humDierction * (1.0f + rand.nextFloat());

                data.add(new DataPoint(((Calendar) lastTime.clone()), lastHumidityMeasurement, lastTempMeasurement));
            }
        }
    }

    public static void main(String[] args) {
        GreenHouseScheduler gh = new GreenHouseScheduler();
        gh.schedule(gh.new Terminate(), 5000);
        gh.repeat(gh.new LightOn(), 600, 2400);
        gh.repeat(gh.new LightOff(), 1800, 2400);
        gh.repeat(gh.new WaterOn(), 800, 2400);
        gh.repeat(gh.new WaterOff(), 900, 2400);
        gh.repeat(gh.new WaterOn(), 1400, 2400);
        gh.repeat(gh.new WaterOff(), 1500, 2400);
        gh.repeat(gh.new ThermostatDay(), 900, 2400);
        gh.repeat(gh.new ThermostatNight(), 2100, 2400);
        gh.repeat(gh.new CollectData(), 0, 500);
        gh.run();
    }
}
