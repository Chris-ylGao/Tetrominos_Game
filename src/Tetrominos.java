import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tetrominos {
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Tetrominos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Board board = new Board(16, 32);
        frame.getContentPane().add(board);

        // display the window
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);

        Timer timer = new Timer(200, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
               board.nextTurn();

            }
        });

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_D) {
                    board.rotateLeft();
                } else if (key == KeyEvent.VK_G) {
                    board.rotateRight();
                } else if (key == KeyEvent.VK_S) {
                    board.slide(-1);
                } else if (key == KeyEvent.VK_F) {
                    board.slide(1);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        timer.start();
    }
        public static void main(String[] args){
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    createAndShowGUI();
                }
            });

    }
}
