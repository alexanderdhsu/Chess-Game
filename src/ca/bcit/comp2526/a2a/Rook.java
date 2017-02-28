package ca.bcit.comp2526.a2a;

import java.awt.Image;
import java.awt.geom.Point2D;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 * Creates and holds information about rook pieces.
 * @author Alex
 * @version 0.7
 */

public class Rook extends Pieces {
    boolean killed;
    String owner;
    Point2D currentPos;
    int pieceId;
    JLabel imageLabel = new JLabel();
    ImageIcon blackPiece = new ImageIcon(new ImageIcon("D:/LocalFiles/Programming/"
            + "Java/Chess-Game/src/images/rookBlack.png"
            ).getImage().getScaledInstance(imageScale, imageScale, Image.SCALE_DEFAULT));
    ImageIcon whitePiece = new ImageIcon(new ImageIcon("D:/LocalFiles/Programming/"
            + "Java/Chess-Game/src/images/rookWhite.png"
            ).getImage().getScaledInstance(imageScale, imageScale, Image.SCALE_DEFAULT));
    /**
     * Constructor.
     * @param color as a string
     * @param piecex as an int
     * @param piecey as an int
     * @param piecez as an int
     */
    
    public Rook(String color, int piecex, int piecey, int piecez) {
        killed = false;
        owner = color;
        currentPos = new Point2D.Double(piecex,piecey);
        pieceId = piecez;
        if (owner.equals("black")) {
            imageLabel.setIcon(blackPiece);
        }
        if (owner.equals("white")) {
            imageLabel.setIcon(whitePiece);
        }
    }

    /**
     * Checks if move is in range.
     * @return false as default
     */
    boolean moveValid(Point2D nextMove) {
        return false;
    }

    /**
     * Checks if piece is currently causing check.
     * @return false as default
     */
    boolean causingCheck() {
        return false;
    }
    
    /**
     * Gets the imageLabel for the piece.
     * @return imageLabel
     */
    JLabel getImage() {
        return imageLabel;
    }

}