package Minesweeper;
import javax.swing.*;

public class Cell extends JToggleButton{

    private int row, column, value;
    private Cell topLeft, topCenter, topRight, left, right, bottomLeft, bottomCenter, bottomRight;
    private boolean isDug;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        isDug = false;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setCells(Cell topLeft, Cell topCenter, Cell topRight, Cell left, Cell right, Cell bottomLeft, Cell bottomCenter, Cell bottomRight) {
        this.topLeft = topLeft;
        this.topCenter = topCenter;
        this.topRight = topRight;
        this.left = left;
        this.right = right;
        this.bottomLeft = bottomLeft;
        this.bottomCenter = bottomCenter;
        this.bottomRight = bottomRight;


    }

}
