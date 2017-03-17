package ca.bcit.comp2526.a2a;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Creates and holds information about rook pieces.
 * @author Alex
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Rook extends Piece {
    JLabel imageLabel = new JLabel();
    ImageIcon blackPiece = new ImageIcon("src/images/rookBlack.png");
    ImageIcon whitePiece = new ImageIcon("src/images/rookWhite.png");
    
    /**
     * Constructor.
     * @param piecex as an int
     * @param piecey as an int
     * @param piecez as an int
     */
    
    public Rook(String owner, int piecex, int piecey, int piecez) {
        color = owner;
        xcoord = piecex;
        ycoord = piecey;
        pieceId = piecez;
        type = "rook";
        if (color.equals("black")) {
            imageLabel.setIcon(blackPiece);
        }
        if (color.equals("white")) {
            imageLabel.setIcon(whitePiece);
        }
    }

    /**
     * Checks if move is in range.
     * @return false as default
     */
    int inRange(int nextX, int nextY) {
        int xcoordCheck = xcoord - nextX;
        int ycoordCheck = ycoord - nextY;

        if ((xcoordCheck == 0) && (ycoordCheck == 0)) {
            return 0;
        } else if ((xcoordCheck == 0) && (ycoordCheck != 0)) {
            return 1;
        } else if ((xcoordCheck != 0) && (ycoordCheck == 0)) {
            return 1;
        }
        return -1;
    }
    
    /**
     * Gets the imageLabel for the piece.
     * @return imageLabel
     */
    JLabel getImage() {
        return imageLabel;
    }
    
    /**
     * Gets the color of the current Piece.
     * @return as a string
     */
    String getColor() {
        return color;
    }
    
    /**
     * Sets the coordinates for each piece.
     * @param piecex as an int
     * @param piecey an an int
     */
    void setCoord(int piecex, int piecey) {
        xcoord = piecex;
        ycoord = piecey;
    }
    
    /**
     * Removes the current piece from the square.
     */
    void remove() {
        xcoord = -1;
        ycoord = -1;
    }
    
    /**
     * Gets the piece type.
     * @return as a string
     */
    String getType() {
        return type;
    }
}