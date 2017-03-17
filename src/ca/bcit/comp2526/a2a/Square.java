package ca.bcit.comp2526.a2a;

import javax.swing.JPanel;

/**
 * Class for creating each square on the chess board. Keeps track of it's own 
 * coordinates and what piece is on the square.
 * @author Alex
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Square extends JPanel {
    final int x;
    final int y;
    private Piece currentPiece = null;
    
    /**
     * Constructor.
     * @param x as an integer
     * @param y as an integer
     */
    Square(int xcoord, int ycoord) {
        x = xcoord;
        y = ycoord;
    }
    
    /**
     * Adds a piece and it's image to the square.
     * @param piece as a Piece
     */
    void placePiece(final Piece piece) {
        currentPiece = piece;
        currentPiece.setCoord(x, y);
        this.add(currentPiece.getImage());
        this.repaint();
    }
    
    /**
     * Adds a piece's image to the square and redraws the square.
     */
    void placePiece() {
        this.add(currentPiece.getImage());
        this.repaint();
    }
    
    /**
     * Returns the piece currently on the square.
     * @return currentPiece
     */
    Piece getPiece() {
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