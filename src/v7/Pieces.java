package v7;

import java.awt.geom.Point2D;

public abstract class Pieces {
    boolean killed;
    boolean color;
    int ID;
    
    abstract boolean moveValid(Point2D point);
    abstract boolean causingCheck();
}