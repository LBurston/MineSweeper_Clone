package com.minesweeper;
import com.minesweeper.field.*;
import com.minesweeper.windows.*;

import java.util.HashSet;

public class Game {

    private GameWindow currentGame;
    private static final int rows = 10;
    private static final int columns = 10;
    private static final int mines = 20;


    public static void main(String[] args) {
        Game obj = new Game();
        obj.run(args);
    }

    public void run(String[] args) {
        currentGame = new GameWindow(rows,columns,mines);
        testMineGenerator();
    }

    /**
     * Prints out a grid of the values in the field
     * -1 represents a mine, the rest indicate how many surrounding mines
     */
    private void testMineGenerator() {
        int[] locations = currentGame.getMinefield().getFieldValues();
        for(int i = 0; i < rows*columns; i++) {
            if(i % columns == 0) {
                System.out.println();
            }
            System.out.print(locations[i] + "\t");
        }
        int mineCount = 0;
        for(int i : locations) {
            if(i == -1) {
                mineCount++;
            }
        }
        System.out.println("\t"+mineCount);
    }

}
