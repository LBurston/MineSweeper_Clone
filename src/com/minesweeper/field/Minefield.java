package com.minesweeper.field;
import com.minesweeper.*;
import com.minesweeper.field.*;
import com.minesweeper.windows.*;

import javax.swing.*;

public class Minefield {

    private int[][] field;
    private int minesRemaining;

    public Minefield(int rows, int columns, int mines) {
        field = new int[rows][columns];
        minesRemaining = mines;
    }



}
