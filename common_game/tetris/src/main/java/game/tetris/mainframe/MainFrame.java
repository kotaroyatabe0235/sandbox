package game.tetris.mainframe;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import game.tetris.tetris.TetrisPanel;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Tetris");
        setSize(TetrisPanel.BLOCK_SIZE * TetrisPanel.BOARD_WIDTH, TetrisPanel.BLOCK_SIZE * TetrisPanel.BOARD_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // TetrisPanelのインスタンスを生成
        TetrisPanel tetrisPanel = new TetrisPanel();
        
        // TetrisPanelをMainFrameに追加
        add(tetrisPanel);

        // キーイベントリスナーの登録
        addKeyListener(tetrisPanel);

        setFocusable(true);
        System.out.println("[DEBUG] キーイベントリスナーの登録が完了");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}
