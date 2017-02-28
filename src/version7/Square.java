package version7;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Square extends JPanel {
    final int xCoord;
    final int yCoord;
    Pieces currentPiece = null;
    
    Square(int x, int y){
        xCoord = x;
        yCoord = y;
    }
    
    void placePiece(Pieces piece) {
        currentPiece = piece;
        this.add(piece.getImage());
        this.repaint();
    }
    
    Pieces getPiece() {
        return currentPiece;
    }
    
    void removePiece() {
        this.remove(currentPiece.getImage());
        this.repaint();
        currentPiece = null;
    }
}