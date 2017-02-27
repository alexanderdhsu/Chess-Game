package v7;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import java.io.IOException;

@SuppressWarnings("serial")
public class Game extends JPanel
{    
    JPanel[][] Squares = new JPanel[8][8];
    
    //adds 64 panels to each square in a gridlayout
    public void setupBoard() throws IOException {
        this.setLayout(new GridLayout(8,8));
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                //creates new square panel in multidimensional array
                Squares[x][y] = new JPanel();
                //adds a panel to the board
                this.add(Squares[x][y]);
                if ((x%2 == 1) && (y%2 == 0)) {
                    Squares[x][y].setBackground(Color.black);
                }
                if ((x%2 == 0) && (y%2 == 1)) {
                    Squares[x][y].setBackground(Color.black);
                }
                Squares[x][y].addMouseListener(new SquareListener());
                
            }
        }
    }
    private class SquareListener implements MouseListener {
        Color original;
        public void mouseClicked(MouseEvent e) {}
        public void mousePressed(MouseEvent e) {
            Object source = e.getSource();
        }
        public void mouseReleased(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {
            Object source = e.getSource();
            original = ((JPanel)source).getBackground();
            ((JPanel) source).setBackground(Color.gray);
        }
        public void mouseExited(MouseEvent e) {
            Object source = e.getSource();
            ((JPanel) source).setBackground(original);
        }
    }
    
    public void setupPieces() {   
        //(Color, x, y, ID)
        King whiteKing = new King("white", 5, 1, 1);
        King blackKing = new King("black", 5, 8, 1);
        Queen whiteQueen = new Queen("white", 4, 1, 1);
        Queen blackQueen = new Queen("black", 4, 8, 1);
        Bishop blackBishop1 = new Bishop("black", 3, 1, 1);
        Bishop blackBishop2 = new Bishop("black", 6, 1, 2);
        Bishop whiteBishop1 = new Bishop("white", 3, 8, 1);
        Bishop whiteBishop2 = new Bishop("white", 6, 8, 2);
        Knight blackKnight1 = new Knight("black", 2, 1, 1);
        Knight blackKnight2 = new Knight("black", 7, 1, 2);
        Knight whiteKnight1 = new Knight("white", 2, 8, 1);
        Knight whiteKnight2 = new Knight("white", 7, 8, 2);
        Rook blackRook1 = new Rook("black", 1, 1, 1);
        Rook blackRook2 = new Rook("black", 8, 1, 2);
        Rook whiteRook1 = new Rook("white", 1, 8, 1);
        Rook whiteRook2 = new Rook("white", 8, 8, 2);
        Pawn blackPawn1 = new Pawn("black", 1, 7, 1);
        Pawn blackPawn2 = new Pawn("black", 2, 7, 2);
        Pawn blackPawn3 = new Pawn("black", 3, 7, 3);
        Pawn blackPawn4 = new Pawn("black", 4, 7, 4);
        Pawn blackPawn5 = new Pawn("black", 5, 7, 5);
        Pawn blackPawn6 = new Pawn("black", 6, 7, 6);
        Pawn blackPawn7 = new Pawn("black", 7, 7, 7);
        Pawn blackPawn8 = new Pawn("black", 8, 7, 8);
        Pawn whitePawn1 = new Pawn("white", 1, 7, 1);
        Pawn whitePawn2 = new Pawn("white", 2, 7, 2);
        Pawn whitePawn3 = new Pawn("white", 3, 7, 3);
        Pawn whitePawn4 = new Pawn("white", 4, 7, 4);
        Pawn whitePawn5 = new Pawn("white", 5, 7, 5);
        Pawn whitePawn6 = new Pawn("white", 6, 7, 6);
        Pawn whitePawn7 = new Pawn("white", 7, 7, 7);
        Pawn whitePawn8 = new Pawn("white", 8, 7, 8);
    }
    
    public void placePieces() {
        JLabel testPiece = new JLabel();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("D:/LocalFiles/Programming/"
                + "Java/Chess-Game/src/images/kingBlack.png"
                ).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        testPiece.setIcon(imageIcon);
        Squares[0][0].add(testPiece);
        //Squares[0][0].remove(testPiece);
    }    
}