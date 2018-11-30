package com.CodeHeap.IO.greenHouseControllerV2;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<Event> events = new ArrayList<>();

    public boolean addEvent(Event e){
        return events.add(e);
    }

    public void run(){
        while(!events.isEmpty()){
            for (Event event : new ArrayList<>(events)) {
                if(event.ready()){
                    event.action();
                    events.remove(event);
                }
            }
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}
