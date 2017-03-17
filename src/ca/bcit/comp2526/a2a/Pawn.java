package ca.bcit.comp2526.a2a;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Creates and holds information about pawn pieces.
 * @author Alex
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Pawn extends Piece {
    JLabel imageLabel = new JLabel();
    ImageIcon blackPiece = new ImageIcon("src/images/pawnBlack.png");
    ImageIcon whitePiece = new ImageIcon("src/images/pawnWhite.png");
    boolean firstMove;
    
    /**
     * Constructor.
     * @param piecex as an int
     * @param piecey as an int
     * @param piecez as an int
     */
    
    public Pawn(String owner, int piecex, int piecey, int piecez) {
        firstMove = true;
        color = owner;
        xcoord = piecex;
        ycoord = piecey;
        pieceId = piecez;
        type = "pawn";
        if (color.equals("black")) {
            imageLabel.setIcon(blackPiece);
        } else if (color.equals("white")) {
            imageLabel.setIcon(whitePiece);
        }
    }

    /**
     * Checks if move is in range.
     * @return false as default
     */
    int inRange(int nextX, int nextY) {
        int ycoordCheck = ycoord - nextY;
        int xcoordCheck = xcoord - nextX;
        
        //if pawn didn't move
        if ((xcoordCheck == 0) && (ycoordCheck == 0)) {
            return 0;
        }
        //if white pawn trying to move 2 spaces
        if ((xcoordCheck == 0) && (ycoordCheck == 2)) {
            if ((color.equals("white")) && (firstMove == true)) {
                firstMove = false;
                return 1;
            }
        }
        //if white pawn trying to move 1 space
        else if ((xcoordCheck == 0) && (ycoordCheck == 1)) {
            if ((color.equals("white"))) {
                firstMove = false;
                return 1;
            }
        } 
        //if black pawn trying to move 1 space
        else if ((xcoordCheck == 0) && (ycoordCheck == -1)) {
            if ((color.equals("black"))) {
                firstMove = false;
                return 1;
            }
        //if black pawn trying to move 2 spaces
        } else if ((xcoordCheck == 0) && (ycoordCheck == -2)) {
            if ((color.equals("black")) && (firstMove == true)) {
                firstMove = false;
                return 1;
            }
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