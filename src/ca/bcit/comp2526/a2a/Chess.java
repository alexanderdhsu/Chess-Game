package ca.bcit.comp2526.a2a;

import java.awt.Dimension;
import java.io.IOException;
import javax.swing.JFrame;
/**
 * Creates a single chess game and sets up the board with pieces.
 * @author Alex
 * @version 0.7
 */

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
        chessGame.setupWhitePieces();
        chessGame.setupBlackPieces();
        frame.getContentPane().add(chessGame);
        frame.pack();
        frame.setVisible(true);
    }
}