package Minesweeper;

public class GameDisplay {

    public Minefield minefield;
    public Game currentGame;

    public GameDisplay(Game currentGame, Minefield minefield) {
        this.currentGame = currentGame; //Passes the current Game through to receive its fields
        this.minefield = minefield;
    }
}
