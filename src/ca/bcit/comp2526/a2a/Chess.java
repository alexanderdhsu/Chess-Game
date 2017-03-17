package ca.bcit.comp2526.a2a;

import java.awt.Dimension;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 * Displays a menu prompt to either start a new chess game or load a saved 
 * game, then sets up a chess board with a side menu and pieces in new or 
 * old positions.
 * @author Alex
 * @version 1.0
 */
public class Chess {
    /**
     * Main method of entry.
     * @param args as a string
     * @throws IOException if board can't be setup
     */
    public static void main(String[] args) throws IOException {       
        JFrame frame = new JFrame("Chess");
        JPanel gui = new JPanel();
        Board chessGame = new Board();
        String[] options = {"New Game", "Load Game"};
        int choice = 0;
        choice = JOptionPane.showOptionDialog(frame, "Do you want to load the previous game?",
                "Choose option: ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, "New Game");
        Menu sideMenu = new Menu();
        
        frame.add(gui);
        chessGame.setPreferredSize(new Dimension(800,800));
        sideMenu.setPreferredSize(new Dimension(400,800));
        if (choice == 1) {
            Board.serialRead();
            chessGame.loadPieces();
        } else {
            chessGame.setupBoard();
            chessGame.setupWhiteRow1();
            chessGame.setupWhiteRow2();
            chessGame.setupBlackRow1();
            chessGame.setupBlackRow2();
        }
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.add(chessGame);
        gui.add(sideMenu);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}