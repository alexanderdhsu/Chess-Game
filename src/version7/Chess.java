package version7;

import java.awt.Dimension;
import java.io.IOException;
import javax.swing.JFrame;

public class Chess {

    /**
     * Main method of entry.
     * @param args as a string
     * @throws IOException if board can't be setup
     */
    public static void main(String[] args) throws IOException {
        Game chessGame = new Game();
        JFrame frame = new JFrame("Chess");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chessGame.setPreferredSize(new Dimension(1000,1000));
        chessGame.setupBoard();
        chessGame.setupPieces();
        frame.getContentPane().add(chessGame);
        frame.pack();
        frame.setVisible(true);
    }
}