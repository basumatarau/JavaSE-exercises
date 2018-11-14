package com.CodeHeap.abstractFactoryVSFactoryMethod.abstractFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Client {
    public static void main(String[] args) {

        List<Maze> mazes = new ArrayList<>();
        Random rand = new Random(47L);
        Maze maze = null;

        MazeGame mazeGame = new MazeGame();

        for (int i = 0; i < 5; i++) {
            if(rand.nextInt(2) == 0){
                maze = mazeGame.createMaze(new MazeFactory());
            }else{
                maze = mazeGame.createMaze(new EnchantedMazeFactory());
            }
            mazes.add(maze);
        }

        for (Maze m : mazes) {
            m.walkThrough();
        }
    }
}
