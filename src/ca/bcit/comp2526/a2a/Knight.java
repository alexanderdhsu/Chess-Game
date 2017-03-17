package ca.bcit.comp2526.a2a;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Creates and holds information about knight pieces.
 * @author Alex
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Knight extends Piece {
    JLabel imageLabel = new JLabel();
    ImageIcon blackPiece = new ImageIcon("src/images/knightBlack.png");
    ImageIcon whitePiece = new ImageIcon("src/images/knightWhite.png");
    
    /**
     * Constructor.
     * @param piecex as an int
     * @param piecey as an int
     * @param piecez as an int
     */
    
    public Knight(String owner, int piecex, int piecey, int piecez) {
        color = owner;
        xcoord = piecex;
        ycoord = piecey;
        pieceId = piecez;
        type = "knight";
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
        int xcoordCheck = Math.abs(xcoord - nextX);
        int ycoordCheck = Math.abs(ycoord - nextY);

        if ((xcoordCheck == 0) && (ycoordCheck == 0)) {
            return 0;
        } else if ((xcoordCheck == 1) && (ycoordCheck == 2)) {
            return 1;
        } else if ((xcoordCheck == 2) && (ycoordCheck == 1)) {
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