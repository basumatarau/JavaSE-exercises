package com.testProject.abstractFactoryVSFactoryMethod.abstractFactory;

import java.util.HashMap;
import java.util.Map;

public class Room implements MapSite {

    private Map<MazeGame.Sides, MapSite> sides;
    private int roomNumber;

    Room(int id) {
        sides = new HashMap<>();
        roomNumber = id;
    }

    public void setSide(MazeGame.Sides side, MapSite site) {
        this.sides.put(side, site);
    }

    public MapSite getSide(MazeGame.Sides side) {
        for (Map.Entry<MazeGame.Sides, MapSite> entry : sides.entrySet()) {
            if (entry.getKey().equals(side)) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public void enter() {
        System.out.println("Enter: Room#" + roomNumber);
    }

    @Override
    public String toString() {
        return "Room#"+roomNumber;
    }
}
