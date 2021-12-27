package com.minesweeper;
import com.minesweeper.field.*;
import com.minesweeper.windows.*;

public class Game {

    public static void main(String[] args) {
        new GameWindow(20, 20, 60);
        new GameWindow();
        new GameWindow(12, 12, 25);
        new GameWindow(8, 8, 10);
    }

}
