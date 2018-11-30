package com.CodeHeap.IO.greenHouseController;

public class ControlsExtension extends GreenhouseControls {

    public class HumidifierOn extends Event {
        HumidifierOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            humidifierIsOn = true;
        }

        @Override
        public String toString() {
            return "Humidifier has been turned on...";
        }
    }

    public class HumidifierOff extends Event {
        HumidifierOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            humidifierIsOn = false;
        }

        @Override
        public String toString() {
            return "Humidifier has been turned off...";
        }
    }
}
