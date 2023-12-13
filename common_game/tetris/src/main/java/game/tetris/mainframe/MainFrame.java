package game.tetris.mainframe;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public final int BORAD_WIDTH = 10;
    public final int BORAD_HEIGHT = 20;
    public final int BLOCK_SIZE = 30;

    public MainFrame() {
        setTitle("Tetris");
        setSize(BORAD_WIDTH*BLOCK_SIZE, BORAD_HEIGHT*BLOCK_SIZE);
        setLayout(null);  
    }
    
}
