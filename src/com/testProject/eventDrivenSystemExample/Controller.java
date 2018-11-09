package com.testProject.eventDrivenSystemExample;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<Event> events = new ArrayList<>();

    public boolean addEvent(Event e) {
        events.add(e);
        return true;
    }

    public void run() {
        while (events.size() > 0) {
            for (Event event : new ArrayList<>(events)) {
                if (event.ready()) {
                    System.out.println(event);
                    event.action();
                    events.remove(event);
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
