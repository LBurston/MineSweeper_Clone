package OldAttempt.field;

import OldAttempt.*;
import OldAttempt.field.*;
import OldAttempt.windows.*;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class Minefield {

    private JToggleButton[] field;
    private int minesRemaining;
    private int[] fieldValue;
    private boolean[] isPressed;
    private Random mineGen;
    private final int rows, columns, mines;

    public Minefield(int rows, int columns, int mines) {
        this.rows = rows;
        this.columns = columns;
        this.mines = mines;
        field = new JToggleButton[rows*columns];
        minesRemaining = mines;
        fieldValue = new int[rows*columns];
        isPressed = new boolean[rows*columns];
        mineGen = new Random();
        populateField();
    }

    public int getSpotRow(JToggleButton spot) {
        return (fieldIndexOf(spot) / rows) + 1;
    }

    public int getSpotColumn(JToggleButton spot) {
        return (fieldIndexOf(spot) % columns) + 1;
    }

    public int getSurroundingSpots(JToggleButton spot) {
        int spotRow = getSpotRow(spot);
        int spotColumn = getSpotColumn(spot);
        if(spotRow != 1 || spotRow != rows) {
            if(spotColumn != 1 || spotColumn != columns) {return 8;}
            return 5;
        }
        return 3;
    }

    public void generateRevealList(JToggleButton originSpot) {
        int surroundingSpots = getSurroundingSpots(originSpot);
        int spotRow = getSpotRow(originSpot);
        int spotColumn = getSpotColumn(originSpot);
        int[] revealList = new int[rows*columns];
        if(surroundingSpots==8) {

        }

    }

    public void buttonPress(JToggleButton spot) {
        System.out.println(isPressed[fieldIndexOf(spot)]);
        if(!isPressed[fieldIndexOf(spot)]) {
            isPressed[fieldIndexOf(spot)] = true;
            if (fieldValueOf(spot) < 0) {
                System.out.println("Game Over");
            } else if (fieldValueOf(spot) > 0) {
                spot.setText(valueToString(spot));
            } else {
                int fieldIndex = fieldIndexOf(spot);
                if (fieldIndex / rows > 0 && fieldIndex % columns > 0) {
                    field[fieldIndex - columns - 1].doClick();
                }
                if (fieldIndex / rows > 0) {
                    field[fieldIndex - columns].doClick();
                }
                if (fieldIndex / rows > 0 && fieldIndex % columns < columns - 1) {
                    field[fieldIndex - columns + 1].doClick();
                }
                if (fieldIndex % columns > 0) {
                    field[fieldIndex - 1].doClick();
                }
                if (fieldIndex % columns < columns - 1) {
                    field[fieldIndex + 1].doClick();
                }
                if (fieldIndex / rows < rows - 1 && fieldIndex % columns > 0) {
                    field[fieldIndex + columns - 1].doClick();
                }
                if (fieldIndex / rows < rows - 1) {
                    field[fieldIndex + columns].doClick();
                }
                if (fieldIndex / rows < rows - 1 && fieldIndex % columns < columns - 1) {
                    field[fieldIndex + columns + 1].doClick();
                }
            }
        }
    }

    private String valueToString(JToggleButton spot) {
        return String.valueOf(fieldValueOf(spot));
    }

    private int fieldValueOf(JToggleButton spot) {
        return fieldValue[(Arrays.asList(field).indexOf(spot))];
    }

    private int fieldIndexOf(JToggleButton spot) {
        return Arrays.asList(field).indexOf(spot);
    }

    public void addToField(JToggleButton fieldSpot, int index) {
        field[index] = fieldSpot;
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
        for (Integer integer : createMines()) {
            fieldValue[integer] = -1;
        }

        for(int i = 0; i < rows * columns; i++) {
            if(!containsMine(i)) {
                int surroundingMines = 0;
                    if(i/rows > 0 && i%columns > 0 && fieldValue[i-columns-1] == -1) {
                        surroundingMines++;
                    }
                    if(i/rows > 0 && fieldValue[i-columns] == -1) {
                        surroundingMines++;
                    }
                    if(i/rows > 0 && i%columns < columns-1 && fieldValue[i-columns+1] == -1) {
                        surroundingMines++;
                    }
                    if(i%columns > 0 && fieldValue[i-1] == -1) {
                        surroundingMines++;
                    }
                    if(i%columns < columns-1 && fieldValue[i+1] == -1) {
                        surroundingMines++;
                    }
                    if(i/rows < rows-1 && i%columns > 0 && fieldValue[i+columns-1] == -1) {
                        surroundingMines++;
                    }
                    if(i/rows < rows-1 && fieldValue[i+columns] == -1) {
                        surroundingMines++;
                    }
                    if(i/rows < rows-1 && i%columns < columns-1 && fieldValue[i+columns+1] == -1) {
                        surroundingMines++;
                    }
                fieldValue[i] = surroundingMines;
            }
        }
    }

    private boolean containsMine(int index) {
        return fieldValue[index] == -1;
    }

    public int[] getFieldValues() {
        return fieldValue;
    }
}
