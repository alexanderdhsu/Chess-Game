package version7;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.JPanel;

/**
 * Creates a new chess games.
 * @author Alex
 *
 */
@SuppressWarnings("serial")
public class Game extends JPanel {
    Square[][] squareList = new Square[8][8];
    Pieces pieceSelected = null;  
    /**
     * Sets up the chess board squares.
     * @throws IOException if setup fails
     */
    
    public void setupBoard() throws IOException {
        this.setLayout(new GridLayout(8,8));
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                //creates new square object
                squareList[x][y] = new Square(x, y);
                //adds a panel to the board
                this.add(squareList[x][y]);
                if ((x % 2 == 1) && (y % 2 == 0)) {
                    squareList[x][y].setBackground(new Color(130,65,0));
                }
                if ((x % 2 == 0) && (y % 2 == 1)) {
                    squareList[x][y].setBackground(new Color(130,65,0));
                }
                squareList[x][y].addMouseListener(new SquareListener());
            }
        }
    }
    /**
     * Listens for clicks from each square.
     * @author Alex
     *
     */
    
    private class SquareListener implements MouseListener {
        Color original;
        
        public void mouseClicked(MouseEvent ex) {
            Object source = ex.getSource();
            if ((pieceSelected == null) && (((Square)source).getPiece() != null)) {
                pieceSelected = ((Square) source).getPiece();
                ((Square) source).removePiece();
            } else if (pieceSelected != null) {
                ((Square) source).placePiece(pieceSelected);
                pieceSelected = null;
            }
        }
        
        public void mousePressed(MouseEvent ex) {}
        
        public void mouseReleased(MouseEvent ex) {}
        
        public void mouseEntered(MouseEvent ex) {
            Object source = ex.getSource();
            original = ((JPanel)source).getBackground();
            if (pieceSelected != null) {
                ((JPanel) source).setBackground(Color.red);
            } else {
                ((JPanel) source).setBackground(Color.gray);
            }
        }
        
        public void mouseExited(MouseEvent ex) {
            Object source = ex.getSource();
            ((JPanel) source).setBackground(original);
        }
    }
    /**
     * Adds each piece to the board.
     */
    
    public void setupPieces() { //(Color, x, y, pieceID)
        King whiteKing = new King("white", 5, 1, 1);
        squareList[4][7].placePiece(whiteKing);
        King blackKing = new King("black", 5, 8, 1);
        squareList[4][0].placePiece(blackKing);
        Queen whiteQueen = new Queen("white", 4, 1, 1);
        squareList[3][7].placePiece(whiteQueen);
        Queen blackQueen = new Queen("black", 4, 8, 1);
        squareList[3][0].placePiece(blackQueen);
        
        Bishop blackBishop1 = new Bishop("black", 3, 1, 1);
        squareList[2][0].placePiece(blackBishop1);
        Bishop blackBishop2 = new Bishop("black", 6, 1, 2);
        squareList[5][0].placePiece(blackBishop2);
        Bishop whiteBishop1 = new Bishop("white", 3, 8, 1);
        squareList[2][7].placePiece(whiteBishop1);
        Bishop whiteBishop2 = new Bishop("white", 6, 8, 2);
        squareList[5][7].placePiece(whiteBishop2);
        
        Knight blackKnight1 = new Knight("black", 2, 1, 1);
        squareList[1][0].placePiece(blackKnight1);
        Knight blackKnight2 = new Knight("black", 7, 1, 2);
        squareList[6][0].placePiece(blackKnight2);
        Knight whiteKnight1 = new Knight("white", 2, 8, 1);
        squareList[1][7].placePiece(whiteKnight1);
        Knight whiteKnight2 = new Knight("white", 7, 8, 2);
        squareList[6][7].placePiece(whiteKnight2);
        
        Rook blackRook1 = new Rook("black", 1, 1, 1);
        squareList[0][0].placePiece(blackRook1);
        Rook blackRook2 = new Rook("black", 8, 1, 2);
        squareList[7][0].placePiece(blackRook2);
        Rook whiteRook1 = new Rook("white", 1, 8, 1);
        squareList[0][7].placePiece(whiteRook1);
        Rook whiteRook2 = new Rook("white", 8, 8, 2);
        squareList[7][7].placePiece(whiteRook2);
        
        Pawn blackPawn1 = new Pawn("black", 1, 7, 1);
        squareList[0][1].placePiece(blackPawn1);
        Pawn blackPawn2 = new Pawn("black", 2, 7, 2);
        squareList[1][1].placePiece(blackPawn2);
        Pawn blackPawn3 = new Pawn("black", 3, 7, 3);
        squareList[2][1].placePiece(blackPawn3);
        Pawn blackPawn4 = new Pawn("black", 4, 7, 4);
        squareList[3][1].placePiece(blackPawn4);
        Pawn blackPawn5 = new Pawn("black", 5, 7, 5);
        squareList[4][1].placePiece(blackPawn5);
        Pawn blackPawn6 = new Pawn("black", 6, 7, 6);
        squareList[5][1].placePiece(blackPawn6);
        Pawn blackPawn7 = new Pawn("black", 7, 7, 7);
        squareList[6][1].placePiece(blackPawn7);
        Pawn blackPawn8 = new Pawn("black", 8, 7, 8);
        squareList[7][1].placePiece(blackPawn8);
        
        Pawn whitePawn1 = new Pawn("white", 1, 7, 1);
        squareList[0][6].placePiece(whitePawn1);
        Pawn whitePawn2 = new Pawn("white", 2, 7, 2);
        squareList[1][6].placePiece(whitePawn2);
        Pawn whitePawn3 = new Pawn("white", 3, 7, 3);
        squareList[2][6].placePiece(whitePawn3);
        Pawn whitePawn4 = new Pawn("white", 4, 7, 4);
        squareList[3][6].placePiece(whitePawn4);
        Pawn whitePawn5 = new Pawn("white", 5, 7, 5);
        squareList[4][6].placePiece(whitePawn5);
        Pawn whitePawn6 = new Pawn("white", 6, 7, 6);
        squareList[5][6].placePiece(whitePawn6);
        Pawn whitePawn7 = new Pawn("white", 7, 7, 7);
        squareList[6][6].placePiece(whitePawn7);
        Pawn whitePawn8 = new Pawn("white", 8, 7, 8);
        squareList[7][6].placePiece(whitePawn8);
    }  
}