package ca.bcit.comp2526.a2a;

import java.awt.geom.Point2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 * Abstract class for the chess pieces.
 * @author Alex
 * @version 0.7
 */

public abstract class Pieces {
    final int imageScale = 50;
    boolean killed;
    boolean color;
    int pieceId;
    JLabel imageLabel;
    ImageIcon blackPiece;
    ImageIcon whitePiece;
    
    /**
     * Checks if move is valid.
     * @param point as a Point2D
     * @return false if invalid
     */
    abstract boolean moveValid(Point2D point);
    
    /**
     * Checks if this piece is putting the king in check.
     * @return true if king is in check
     */
    abstract boolean causingCheck();
    
    /**
     * Returns the JLabel for the piece
     * @return JLabel for piece
     */
    abstract JLabel getImage();
}