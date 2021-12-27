package com.minesweeper.field;

import com.minesweeper.*;
import com.minesweeper.field.*;
import com.minesweeper.windows.*;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class Minefield {

    private JButton[][] field;
    private int minesRemaining;
    private int[][] fieldValue;
    private Random mineGen;
    private final int rows, columns, mines;

    public Minefield(int rows, int columns, int mines) {
        this.rows = rows;
        this.columns = columns;
        this.mines = mines;
        field = new JButton[rows][columns];
        minesRemaining = mines;
        fieldValue = new int[rows][columns];
        mineGen = new Random();
        populateField();
    }

    public void addToField(JButton fieldSpot, int row, int column) {
        field[row][column] = fieldSpot;
    }

    public HashSet<Integer> createMines() {
        int spaces = rows * columns;
        HashSet<Integer> randomSpots = new HashSet<>();
        while (randomSpots.size() < mines) {
            int location = mineGen.nextInt(spaces);
            randomSpots.add(location);
        }
        return randomSpots;
    }

    private void populateField() {
        Iterator<Integer> it = createMines().iterator();
        while (it.hasNext()) {
            fieldValue[it.next() / rows][it.next() % columns] = -1;
        }

        for(int i = 0; i < rows * columns; i++) {
            if(!containsMine(i/rows, i%columns)) {
                int surroundingMines = 0;
                    if(i/rows > 0 && i%columns > 0 && fieldValue[i/rows - 1][i%columns - 1] == -1) {
                        surroundingMines++;
                    }
                    if(i/rows > 0 && fieldValue[i/rows - 1][i%columns] == -1) {
                        surroundingMines++;
                    }
                    if(i/rows > 0 && i%columns < columns-1 && fieldValue[i/rows - 1][i%columns + 1] == -1) {
                        surroundingMines++;
                    }
                    if(i%columns > 0 && fieldValue[i/rows][i%columns - 1] == -1) {
                        surroundingMines++;
                    }
                    if(i%columns < columns-1 && fieldValue[i/rows][i%columns + 1] == -1) {
                        surroundingMines++;
                    }
                    if(i/rows < rows-1 && i%columns > 0 && fieldValue[i/rows + 1][i%columns - 1] == -1) {
                        surroundingMines++;
                    }
                    if(i/rows < rows-1 && fieldValue[i/rows + 1][i%columns] == -1) {
                        surroundingMines++;
                    }
                    if(i/rows < rows-1 && i%columns < columns-1 && fieldValue[i/rows + 1][i%columns + 1] == -1) {
                        surroundingMines++;
                    }
                fieldValue[i/rows][i%columns] = surroundingMines;
            }
        }
    }

    private boolean containsMine(int row, int column) {
        if(fieldValue[row][column] == -1) { return true;}
        else { return false; }
    }

    public int[][] getFieldValues() {
        return fieldValue;
    }
}
