package v2;

/**
 * This is the main class of the chess game.
 * @author Alex
 * @version 2.0
 */
import javax.swing.*;
public class Chess {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Chess");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ChessBoard());
        frame.pack();
        frame.setVisible(true);
    }
}