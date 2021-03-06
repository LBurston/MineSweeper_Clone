package OldAttempt.windows;
import OldAttempt.field.Cell;
import OldAttempt.field.Minefield;
import OldAttempt.*;
import OldAttempt.windows.*;
import OldAttempt.field.*;
import javax.swing.*;
import java.awt.*;


public class GameWindow {

    private Container container;
    private final int rows;
    private final int columns;
    private final int mines;
    private final int width;
    private final int height;
    private final int buttonSize;
    private Minefield minefield;

    public GameWindow() {
        rows = 16;
        columns = 16;
        mines = 40;
        buttonSize = 40;
        width = rows * buttonSize;
        height = (columns * buttonSize) + 40;
        minefield = new Minefield(rows, columns, mines);
        createWindow();
    }

    public GameWindow(int rows, int columns, int mines) {
        this.rows = rows;
        this.columns = columns;
        this.mines = mines;
        if(rows * 20 < 240) {
            buttonSize = 240 / rows;
        } else { buttonSize = 20; }

        width = rows * buttonSize;
        height = (columns * buttonSize) + 40;
        minefield = new Minefield(rows, columns, mines);
        createWindow();
    }

    public void createWindow() {
        JFrame msWindow = new JFrame("MineSweeper Clone");
        msWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        msWindow.setVisible(true);
        msWindow.setJMenuBar(createMenuBar());
        container = msWindow.getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
        container.setPreferredSize(new Dimension(width, height));
        createHUD();
        createField();

        msWindow.pack();
    }

    public void createHUD() {
        // Creates the hud panel shell containing all HUD items and sets a horiz. box layout
        JPanel hudPanel = new JPanel();
        hudPanel.setLayout(new BoxLayout(hudPanel, BoxLayout.LINE_AXIS));
        hudPanel.setPreferredSize(new Dimension(300, 40));
        // Creates a panel to contain two bits of text vertically
        JPanel textBox = new JPanel();
        textBox.setLayout(new BoxLayout(textBox, BoxLayout.PAGE_AXIS));
        textBox.add(new JLabel("Time Elapsed: 00:00"));
        textBox.add(new JLabel("Mines Remaining: " + mines));
        // Adds all elements to outer HUD panel
        hudPanel.add(new JToggleButton("Restart"));
        hudPanel.add(Box.createHorizontalGlue());
        hudPanel.add(textBox);
        // Adds the HUD panel to the Frame
        container.add(hudPanel);
    }

    public void createField() {
        JPanel fieldPanel = new JPanel();
        fieldPanel.setPreferredSize(new Dimension(width,height));
        fieldPanel.setLayout(new GridLayout(rows, columns, 0, 0));

//        for (int i = 0; i < rows * columns; i++) {
//            JToggleButton fieldSpot = new JToggleButton();
//            fieldSpot.setPreferredSize(new Dimension(buttonSize,buttonSize));
//            fieldPanel.add(fieldSpot);
//            minefield.addToField(fieldSpot, i);
//            fieldSpot.addActionListener((ev) -> minefield.buttonPress(fieldSpot));
//        }
        for (int i = 0; i < rows * columns; i++) {
            Cell fieldCell = new Cell((i/10)+1, (i%10)+1);
            fieldCell.setPreferredSize(new Dimension(buttonSize,buttonSize));
            fieldPanel.add(fieldCell);
            minefield.addToField(fieldCell, i);
            fieldCell.addActionListener((ev) -> minefield.buttonPress(fieldCell));
        }

        container.add(fieldPanel);

    }

    private JMenuBar createMenuBar() {
        JMenuBar menu = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu settingsMenu = new JMenu("Settings");
        JMenu helpMenu = new JMenu("Help");
        menu.add(fileMenu);
        menu.add(settingsMenu);
        menu.add(helpMenu);
        JMenuItem newGame = new JMenuItem("New Game");
        JMenuItem restartGame = new JMenuItem("Restart Game");
        JMenuItem exitGame = new JMenuItem("Exit");
        fileMenu.add(newGame);
        fileMenu.add(restartGame);
        fileMenu.addSeparator();
        fileMenu.add(exitGame);
        JMenuItem howTo = new JMenuItem("How To Play");
        JMenuItem about = new JMenuItem("About");
        helpMenu.add(howTo);
        helpMenu.add(about);
        exitGame.addActionListener((ev) -> System.exit(0));
        return menu;
    }

    public Minefield getMinefield() {
        return minefield;
    }

}
