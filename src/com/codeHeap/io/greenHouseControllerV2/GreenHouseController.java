package com.codeHeap.io.greenHouseControllerV2;

public class GreenHouseController {
    public static void main(String[] args) {
        GreenHouseControls controls = new GreenHouseControls();

        Event[] repeatedEvents = {
                controls.new LightsOn(60 * 60 * 18),
                controls.new LightsOff(60 * 60 * 9),
                controls.new WaterOn(60 * 60 * 11),
                controls.new WaterOff(60 * 60 * 12),
                controls.new WaterOn(60 * 60 * 17),
                controls.new WaterOff(60 * 60 * 18),
                controls.new ThermostatDay(60 * 60 * 7),
                controls.new ThermostatNight(60 * 60 * 19),
        };

        controls.addEvent(controls.new Bell(60 * 60 * 12));
        controls.addEvent(controls.new Bell(60 * 60 * 13));
        controls.addEvent(controls.new Restart(24 * 60 * 60, repeatedEvents));
        controls.addEvent(controls.new Terminate(24 * 60 * 60 * 3));

        controls.run();
    }
}
