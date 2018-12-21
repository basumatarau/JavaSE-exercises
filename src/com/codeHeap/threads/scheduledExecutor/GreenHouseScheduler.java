package com.codeHeap.threads.scheduledExecutor;

import java.util.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
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

    private ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(10);

    public void schedule(Runnable event, long delayTime) {
        scheduler.schedule(event, delayTime, TimeUnit.MILLISECONDS);
    }

    public void repeat(Runnable event, long delayTime, long cycleLength) {
        scheduler.scheduleAtFixedRate(event, delayTime, cycleLength, TimeUnit.MILLISECONDS);
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
            scheduler.shutdownNow();
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

    class CollectData implements Runnable{
        @Override
        public void run() {
            System.out.println("collecting data...");
            synchronized (GreenHouseScheduler.this){
                lastTime.set(Calendar.MINUTE, lastTime.get(Calendar.MINUTE) + 30);

                if (rand.nextInt(5)==4){
                    temDirection = -temDirection;
                }
                lastTempMeasurement += temDirection * (1.0f + rand.nextFloat());

                if(rand.nextInt(5)==4){
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
    }
}
