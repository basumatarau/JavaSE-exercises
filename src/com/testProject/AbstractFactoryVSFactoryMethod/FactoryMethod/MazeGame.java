package com.testProject.AbstractFactoryVSFactoryMethod.FactoryMethod;

public class MazeGame implements MazeCreator {

    enum Sides {
        NORTH, SOUTH, EAST, WEST
    }

    private Maze makeMaze(){
        return new Maze();
    }

    protected Room makeRoom(int id){
        return new Room(id);
    }

    protected Door makeDoor(Room room1, Room room2){
        return new Door(room1, room2);
    }

    protected Wall makeWall(){
        return new Wall();
    }

    @Override
    public Maze createMaze() {
        Maze maze = makeMaze();
        Room room1 = makeRoom(1);
        Room room2 = makeRoom(2);

        Door door = makeDoor(room1, room2);
        maze.addRoom(room1);
        maze.addRoom(room2);

        room1.setSide(Sides.NORTH, door);
        room1.setSide(Sides.SOUTH, makeWall());
        room1.setSide(Sides.EAST, makeWall());
        room1.setSide(Sides.WEST, makeWall());

        room2.setSide(Sides.NORTH, makeWall());
        room2.setSide(Sides.SOUTH, door);
        room2.setSide(Sides.EAST, makeWall());
        room2.setSide(Sides.WEST, makeWall());

        return maze;
    }
}
