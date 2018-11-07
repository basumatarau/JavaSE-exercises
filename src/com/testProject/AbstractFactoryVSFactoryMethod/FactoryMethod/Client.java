package com.testProject.AbstractFactoryVSFactoryMethod.FactoryMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Client {
    public static void main(String[] args) {

        MazeCreator mazeGame = new MazeGame();
        MazeCreator enchantedMazeGame = new EnchantedMazeGame();

        List<Maze> mazes = new ArrayList<>();
        Random rand = new Random(47L);
        Maze maze = null;
        for (int i = 0; i < 5; i++) {
            if(rand.nextInt(2) == 0){
                maze = mazeGame.createMaze();
            }else{
                maze = enchantedMazeGame.createMaze();
            }
            mazes.add(maze);
        }

        for (Maze m : mazes) {
            m.walkThrough();
        }
    }
}
