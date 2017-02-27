package v7;

import java.awt.geom.Point2D;

public class Rook extends Pieces {
    boolean killed;
    String owner;
    Point2D currentPos;
    int ID;
    
    public Rook(String color, int x, int y, int z) {
        killed = false;
        owner = color;
        currentPos = new Point2D.Double(x,y);
        ID = z;
    }

    boolean moveValid(Point2D nextMove) {
        return false;
    }

    boolean causingCheck() {
        return false;
    }

}