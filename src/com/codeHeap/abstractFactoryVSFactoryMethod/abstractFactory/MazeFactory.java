package com.codeHeap.abstractFactoryVSFactoryMethod.abstractFactory;

public class MazeFactory implements AbstractFactory {

    public Maze makeMaze(){
        return new Maze();
    }

    public Room makeRoom(int id){
        return new Room(id);
    }

    public Door makeDoor(Room room1, Room room2){
        return new Door(room1, room2);
    }

    public Wall makeWall(){
        return new Wall();
    }

}
