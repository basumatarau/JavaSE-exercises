package com.CodeHeap.ReflectionAPI.NullObject.StaffExample;

import java.util.ArrayList;

public class Staff extends ArrayList<Position> {
    public void add(String title, Person person) {
        add(new Position(title, person));
    }

    public void add(String title) {
        add(new Position(title));
    }

    public Staff(String... titles) {
        for (String title : titles) {
            add(title);
        }
    }

    public boolean positionAvailable(String title) {
        for (Position position : this) {
            if(position.getTitle().equals(title)&&
                    position.getPerson()==Person.NULL){
                return true;
            }
        }
        return false;
    }

    public void fillPosition(String title, Person hire){
        for (Position position : this) {
            if(position.getTitle().equals(title)&&
            position.getPerson()==Person.NULL){
                position.setPerson(hire);
                return;
            }
        }
        throw new RuntimeException("position: "+title+" is not available");
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Staff:\n");
        for (Position position : this) {
            result.append(position).append('\n');
        }
        return result.toString();
    }
}
