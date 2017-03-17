package ca.bcit.comp2526.a2a;

import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Abstract class for the chess pieces.
 * @author Alex
 * @version 1.0
 */
@SuppressWarnings("serial")
public abstract class Piece implements Serializable {
    final int imageScale = 50;
    int pieceId;
    int xcoord;
    int ycoord;
    JLabel imageLabel;
    ImageIcon blackPiece;
    ImageIcon whitePiece;
    String color;
    String type;
    
    /**
     * Checks if move is valid for that piece.
     * @param point x and point y
     * @return -1 if false, 1 if true, 0 if in same spot
     */
    abstract int inRange(int x, int y);
    
    /**
     * Gets the JLabel for the piece.
     * @return JLabel for piece
     */
    abstract JLabel getImage();
    
    /**
     * Gets the color of the current Piece.
     * @return as a string
     */
    abstract String getColor();
    
    /**
     * Sets the coordinates for each piece.
     * @param piecex as an int
     * @param piecey an an int
     */
    abstract void setCoord(int piecex, int piecey);
    
    /**
     * Removes the current piece from the square.
     */
    abstract void remove();
    
    /**
     * Gets the piece type.
     * @return as a string
     */
    abstract String getType();
}