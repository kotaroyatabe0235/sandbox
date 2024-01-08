package game.tetris.tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class TetrisPanel extends JPanel implements ActionListener, KeyListener {

    public static final int BOARD_WIDTH = 10;
    public static final int BOARD_HEIGHT = 20;
    public static final int BLOCK_SIZE = 30;

    private boolean[][] board;
    private int[][][] shapes;
    private Timer timer;

    private int currentX;
    private int currentY;
    private int currentShape;
    private int rotation;

    public TetrisPanel() {
        init();
        setFocusable(true);
        addKeyListener(this);
    }

    private void init() {
        // ゲームボードの初期化
        board = new boolean[BOARD_HEIGHT][BOARD_WIDTH];

        // テトリスブロックの形状の初期化
        initShape();

        // ゲームの初期化
        initGame();
    }

    private void initShape() {
        shapes = new int[][][]{
            {{1, 1, 1, 1}},
            {{1, 1, 1}, {1}},
            {{1, 1, 1}, {0, 0, 1}},
            {{1, 1, 1}, {0, 1}},
            {{1, 1, 1}, {1, 0}}
        };
    }

    private void initGame() {
        timer = new Timer(500, e -> {
            SwingUtilities.invokeLater(() -> {
                moveDown();
                repaint();
            });
        });
        timer.start();

        // 新しいテトリミノの生成
        spawnNewTetrimino();
    }

    private void spawnNewTetrimino() {
        // 現在のテトリミノを確定
        placeTetrimino();
    
        currentX = BOARD_WIDTH / 2;
        currentY = 0;
        currentShape = (int) (Math.random() * shapes.length);
        rotation = 0;
    
        // 衝突がないか確認
        if (collision()) {
            gameOver();
        }
    }

    private void gameOver() {
        timer.stop();
        JOptionPane.showMessageDialog(this, "Game Over!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private boolean collision() {
        int[] shape = shapes[currentShape][rotation];
        for (int j = 0; j < shape.length; j++) {
            if (shape[j] != 0) {
                int x = currentX + j;
                int y = currentY;
                System.out.println("[DEBUG] Checking collision at X: " + x + ", Y: " + y);
                if (x < 0 || x > BOARD_WIDTH || y > BOARD_HEIGHT || (y > 0 && board[y][x])) {
                    return true; // 衝突がある
                }
            }
        }
        return false; // 衝突がない
    }
      
    

    private void placeTetrimino() {
        int[] shape = shapes[currentShape][rotation];
        for (int j = 0; j < shape.length; j++) {
            if (shape[j] != 0) {
                int x = currentX + j;
                int y = currentY;
                if (y >= 0) {
                    board[y][x] = true;
                }
            }
        }
    }

    private void clearLines() {
        for (int i = BOARD_HEIGHT - 1; i >= 0; i--) {
            boolean isLineFull = true;
            for (int j = 0; j < BOARD_WIDTH; j++) {
                if (!board[i][j]) {
                    isLineFull = false;
                    break;
                }
            }

            if (isLineFull) {
                for (int k = i; k > 0; k--) {
                    System.arraycopy(board[k - 1], 0, board[k], 0, BOARD_WIDTH);
                }
                // 一番上の行をクリア
                java.util.Arrays.fill(board[0], false);
            }
        }
    }

    private void moveDown() {
        currentY++;
    
        // 衝突があるか確認
        if (collision()) {
            currentY--;
            // テトリミノを確定
            placeTetrimino();
            clearLines();
            // 新しいテトリミノを生成
            spawnNewTetrimino();
        }
    }
    
    

    private void moveLeft() {
        currentX--;

        // 衝突があるか確認
        if (collision()) {
            currentX++;
        }
    }

    private void moveRight() {
        currentX++;

        // 衝突があるか確認
        if (collision()) {
            currentX--;
        }
    }

    private void rotate() {
        rotation = (rotation + 1) % 4;

        // 衝突があるか確認
        if (collision()) {
            rotation = (rotation - 1 + 4) % 4;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                moveRight();
                break;
            case KeyEvent.VK_DOWN:
                moveDown();
                break;
            case KeyEvent.VK_UP:
                rotate();
                break;
        }
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        moveDown();
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // 未使用
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // 未使用
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBoard(g);
        drawTetrimino(g);
    }

    private void drawTetrimino(Graphics g) {
        int[] shape = shapes[currentShape][rotation];
        for (int j = 0; j < shape.length; j++) {
            if (shape[j] != 0) {
                g.setColor(Color.RED);
                // 着地時の微調整
                g.fillRect((currentX + j) * BLOCK_SIZE, (currentY - 1) * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
                g.setColor(Color.BLACK);
                g.drawRect((currentX + j) * BLOCK_SIZE, (currentY - 1) * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
            }
        }
    }
    

    private void drawBoard(Graphics g) {
        int xOffset = 10; // 左側の余白
        int yOffset = 10; // 上側の余白
    
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                if (board[i][j]) {
                    int x = xOffset + j * BLOCK_SIZE;
                    int y = yOffset + i * BLOCK_SIZE;
    
                    g.setColor(Color.BLUE);
                    g.fillRect(x, y, BLOCK_SIZE, BLOCK_SIZE);
                    g.setColor(Color.BLACK);
                    g.drawRect(x, y, BLOCK_SIZE, BLOCK_SIZE);
                }
            }
        }
    }
}
