package version7;

import java.awt.geom.Point2D;
import javax.swing.JLabel;

public abstract class Pieces {
    boolean killed;
    boolean color;
    int pieceId;
    
    abstract boolean moveValid(Point2D point);
    
    abstract boolean causingCheck();
    
    abstract JLabel getImage();
}