package v7;

import java.awt.Dimension;
import java.io.IOException;
import javax.swing.JFrame;

public class Chess {

    public static void main(String[] args) throws IOException {
        Game chessGame = new Game();
        JFrame frame = new JFrame("Chess");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chessGame.setPreferredSize(new Dimension(1000,1000));
        chessGame.setupBoard();
        chessGame.placePieces();
        frame.getContentPane().add(chessGame);
        frame.pack();
        frame.setVisible(true);
    }
}