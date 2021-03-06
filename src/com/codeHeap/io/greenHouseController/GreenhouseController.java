package com.codeHeap.io.greenHouseController;

public class GreenhouseController {
    public static void main(String[] args) {
        ControlsExtension controls = new ControlsExtension();

        controls.addEvent(controls.new Bell(900));
        Event[] events = {
                controls.new LightsOff(100),
                controls.new HumidifierOn(150),
                controls.new ThermostatDay(200),
                controls.new WaterOn(300),
                controls.new WaterOff(450),
                controls.new WaterOn(600),
                controls.new WaterOff(750),
                controls.new HumidifierOff(800),
                controls.new ThermostatNight(900),
                controls.new LightsOn(950)
        };

        controls.addEvent(controls.new Restart(1000, events));

        controls.addEvent(controls.new Terminate(5000));

        controls.run();
    }
}
