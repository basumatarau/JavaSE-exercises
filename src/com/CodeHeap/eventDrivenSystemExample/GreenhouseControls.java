package com.CodeHeap.eventDrivenSystemExample;

public class GreenhouseControls extends Controller {
    private boolean lights = false;
    private boolean water = false;
    private String thermostat = "day";
    protected boolean humidifierIsOn = false;

    public class LightsOn extends Event {
        public LightsOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            lights = true;
        }

        @Override
        public String toString() {
            return "Lights have been turned on...";
        }
    }

    public class LightsOff extends Event {
        public LightsOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            lights = false;
        }

        @Override
        public String toString() {
            return "Lights have been turned off...";
        }
    }

    public class WaterOn extends Event {
        public WaterOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            water = true;
        }

        @Override
        public String toString() {
            return "Water supply has been turned on...";
        }
    }

    public class WaterOff extends Event {
        public WaterOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            water = false;
        }

        @Override
        public String toString() {
            return "Water supply has been turned off...";
        }
    }

    public class ThermostatDay extends Event {
        public ThermostatDay(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "day";
        }

        @Override
        public String toString() {
            return "thermostat has been switched to a day mode...";
        }
    }

    public class ThermostatNight extends Event {
        public ThermostatNight(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "night";
        }

        @Override
        public String toString() {
            return "Thermostat has been switched to a night mode...";
        }
    }

    public class Bell extends Event {
        public Bell(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            addEvent(new Bell(delayTime));
        }

        @Override
        public String toString() {
            return "Bell is ringing...";
        }
    }

    public class Restart extends Event {
        private Event[] events;

        public Restart(long delaytime, Event[] events) {
            super(delaytime);
            this.events = events;
            for (Event event : events) {
                addEvent(event);
            }
        }

        @Override
        public void action() {
            for (Event event : events) {
                event.start();
                addEvent(event);
            }
            start();
            addEvent(this);
        }

        @Override
        public String toString() {
            return "System reboot...";
        }
    }

    public class Terminate extends Event {
        public Terminate(long delayteime) {
            super(delayteime);
        }

        @Override
        public void action() {
            System.exit(0);
        }

        @Override
        public String toString() {
            return "System shutdown...";
        }
    }
}
