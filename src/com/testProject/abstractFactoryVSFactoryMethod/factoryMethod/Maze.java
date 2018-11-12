package com.testProject.abstractFactoryVSFactoryMethod.factoryMethod;

import java.util.ArrayList;
import java.util.List;

public class Maze {
    List<Room> rooms;

    Maze(){
        rooms = new ArrayList<>();
    }

    public void addRoom(Room room){
        rooms.add(room);
    }
    public int roomNum(){
        return rooms.size();
    }

    public void walkThrough(){
        for (Room room : rooms) {
            room.enter();
            room.getSide(MazeGame.Sides.NORTH).enter();
            room.getSide(MazeGame.Sides.SOUTH).enter();
            room.getSide(MazeGame.Sides.EAST).enter();
            room.getSide(MazeGame.Sides.WEST).enter();
        }
    }
}
