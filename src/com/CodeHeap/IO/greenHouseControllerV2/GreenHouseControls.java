package com.CodeHeap.IO.greenHouseControllerV2;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GreenHouseControls extends Controller{
    private boolean lights = false;
    private boolean water = false;
    private String thermostat = "night";

    public class LightsOn extends Event{
        public LightsOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            GreenHouseControls.this.lights = true;
            System.out.println("lights have been turned on");
        }
    }

    public class LightsOff extends Event{
        @Override
        public void action() {
            GreenHouseControls.this.lights = false;
            System.out.println("Lights have been turned off");
        }

        public LightsOff(long delayTime) {
            super(delayTime);
        }
    }

    public class WaterOn extends Event{
        @Override
        public void action() {
            GreenHouseControls.this.water = true;
            System.out.println("Water supply has been turned on");
        }

        public WaterOn(long delayTime) {
            super(delayTime);
        }
    }

    public class WaterOff extends Event{
        @Override
        public void action() {
            GreenHouseControls.this.water = false;
            System.out.println("Water supply has been shut down");
        }

        public WaterOff(long delayTime) {
            super(delayTime);
        }
    }

    public class ThermostatDay extends Event {
        public ThermostatDay(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "day";
            System.out.println("thermostat has been switched to a day mode...");
        }
    }

    public class ThermostatNight extends Event {
        public ThermostatNight(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            System.out.println("Thermostat has been switched to a night mode...");
            thermostat = "night";
        }
    }

    public class Bell extends Event {
        public Bell(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            System.out.println("bell is ringing");
            addEvent(new Bell(delayTime));
        }
    }

    public class Restart extends Event{
        private Event[] events;

        public Restart(long delayTime, Event[] events) {
            super(delayTime);
            this.events = events;
            for (Event event : events) {
                GreenHouseControls.this.addEvent(event);
            }
        }

        @Override
        public void action() {
            System.out.println("system reboot...");
            for (Event event : this.events) {
                addEvent(event);
                event.start();
            }
            addEvent(this);
            start();
        }
    }

    public class Terminate extends Event{
        @Override
        public void action() {
            System.out.println("system shutdown...");
            System.exit(0);
        }

        public Terminate(long delayTime) {
            super(delayTime);
        }
    }

    public void loadSequenceAndRun(File f){
        List<Event> repeatedEvents = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(f))){
            String line;
            while((line = bufferedReader.readLine())!=null){

                Class<? extends Event> eventFactory = getEventFactory(line);
                if(eventFactory !=null){
                    try {

                        Matcher matcher = Pattern.compile("\\d+").matcher(line);
                        String group;
                        if(matcher.find()){
                            group = matcher.group();
                        }else{
                            continue;
                        }

                        if(line.matches(".*repeat at every restart.*")){
                            Event event = eventFactory.getDeclaredConstructor(this.getClass(), Long.TYPE)
                                    .newInstance(this, Long.valueOf(group));
                            repeatedEvents.add(event);
                        }else if(line.matches(".*restart cycle.*")){
                            Event event = eventFactory.getDeclaredConstructor(this.getClass(), Long.TYPE, Event[].class)
                                    .newInstance(this, Long.valueOf(group), repeatedEvents.toArray(new Event[1]));
                            addEvent(event);
                        }else{
                            Event event = eventFactory.getDeclaredConstructor(this.getClass(), Long.TYPE)
                                    .newInstance(this, Long.valueOf(group));
                            addEvent(event);
                        }
                    }catch (NoSuchMethodException | InstantiationException
                            | IllegalAccessException | InvocationTargetException e){
                        throw new RuntimeException(e);
                    }
                }
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        run();
    }

    private Class<? extends Event> getEventFactory(String line) {
        Class<? extends Event> result = null;

        for (Class<?> aClass : GreenHouseControls.class.getClasses()) {
            if(aClass.getSuperclass().equals(Event.class)
                    && line.matches(".*"+aClass.getSimpleName()+".*")){
                result = (Class<? extends Event>)aClass;
            }
        }
        return result;
    }

    public void loadSequenceAndRun(String fpath){
        loadSequenceAndRun(new File(fpath));
    }
}
