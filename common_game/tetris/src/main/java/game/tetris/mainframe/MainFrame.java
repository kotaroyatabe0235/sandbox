package game.tetris.mainframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

public class MainFrame extends JFrame implements ActionListener {

    public final int BORAD_WIDTH = 10;
    public final int BORAD_HEIGHT = 20;
    public final int BLOCK_SIZE = 30;

    // ゲームボードの定義
    private boolean[][] board;
    // ブロックの形状定義
    private int[][][] shapes;
    // 時間進行を管理
    private Timer timer;

    // 座標定義
    private int currentX;
    private int currentY;
    private int currentShape;
    private int rotation;

    public MainFrame() {
        setTitle("Tetris");
        setSize(BORAD_WIDTH*BLOCK_SIZE, BORAD_HEIGHT*BLOCK_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // ゲームボードの初期化
        board = new boolean[BORAD_HEIGHT][BORAD_WIDTH];

    }

    private void initShape() {
        // 各ブロックの形状を定義
        shapes = new int[][][]{
            {{1,1,1,1}},
            {{1,1,1},{1}},
            {{1,1,1},{0,0,1}},
            {{1,1,1},{0,1}},
            {{1,1,1},{1,0}}
        };
    }

    private void initGame() {
        timer = new Timer(500, this);
        timer.start();

        // 新しいテトリミノの生成
        spawnNewTetrimino();
    }

    private void spawnNewTetrimino() {
        currentX = BORAD_WIDTH / 2;
        currentY = 0;
        currentShape = (int) (Math.random() * shapes.length);
        rotation = 0;

        // 衝突が無いか確認
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}
