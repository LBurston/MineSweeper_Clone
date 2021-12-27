package com.minesweeper;
import com.minesweeper.field.*;
import com.minesweeper.windows.*;

import java.util.HashSet;

public class Game {

    private GameWindow currentGame;

    public static void main(String[] args) {
        Game obj = new Game();
        obj.run(args);
    }

    public void run(String[] args) {
        currentGame = new GameWindow(20,20,70);
        testMineGenerator();
    }

    /**
     * Prints out a grid of the values in the field
     * -1 represents a mine, the rest indicate how many surrounding mines
     */
    private void testMineGenerator() {
        int[][] locations = currentGame.getMinefield().getFieldValues();
        for(int i = 0; i < 20*20; i++) {
            if(i % 20 == 0) {
                System.out.println();
            }
            System.out.print(locations[i / 20][i % 20] + "\t");
        }
    }

}
