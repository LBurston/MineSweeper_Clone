package OldAttempt.field;
import javax.swing.*;

public class Cell extends JToggleButton{
    final private int row;
    final private int column;
    private int value;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        value = 0;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
