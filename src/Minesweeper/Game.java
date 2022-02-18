package Minesweeper;

public class Game {

    private final int rows;
    private final int columns;
    private final int mines;
    private int minesRemaining;
    private Minefield minefield;
    private GameDisplay display;

    public Game(int rows, int columns, int mines) {
        this.rows = rows;
        this.columns = columns;
        this.mines = mines;
        minefield = new Minefield(this);
        display = new GameDisplay(this, minefield);
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getMines() {
        return mines;
    }

    public int getMinesRemaining() {
        return minesRemaining;
    }

    public void increaseMinesRemaining() {
        if(minesRemaining<mines) { minesRemaining++; }
    }

    public void decreaseMinesRemaining() {
        if(minesRemaining>0) { minesRemaining--; }
    }

    public GameDisplay getDisplay() {
        return display;
    }
}