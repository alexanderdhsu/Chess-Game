package ca.bcit.comp2526.a2a;

import javax.swing.JPanel;
/**
 * Class for creating each square on the chess board. Keeps track of it's own 
 * coordinates and what piece is on the square.
 * @author Alex
 * @version 0.7
 */
@SuppressWarnings("serial")
public class Square extends JPanel {
    final int xCoord;
    final int yCoord;
    Pieces currentPiece = null;
    
    /**
     * Constructor.
     * @param x as an integer
     * @param y as an integer
     */
    Square(int x, int y){
        xCoord = x;
        yCoord = y;
    }
    
    /**
     * Adds a piece and it's image to the square.
     * @param piece as a Pieces
     */
    void placePiece(final Pieces piece) {
        currentPiece = piece;
        this.add(piece.getImage());
        this.repaint();
    }
    
    /**
     * Returns the piece currently on the square.
     * @return currentPiece
     */
    Pieces getPiece() {
        return currentPiece;
    }
    
    /**
     * Deletes the piece currently on the square.
     */
    void removePiece() {
        this.removeAll();
        this.repaint();
        currentPiece = null;
    }
}