package ca.bcit.comp2526.a2a;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JPanel;

/**
 * Contains the methods for setting the the board, creating and placing the
 * pieces, loading new pieces from the save, reading and writing a game to
 * a file, for checking if the movement path is clear, and mouse listeners 
 * for each square.
 * @author Alex
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Board extends JPanel {
    //Multidimensional array containing the squares.
    static Square[][] squareList = new Square[8][8];
    //Contains a piece that is being moved, otherwise null
    private Piece heldPiece = null;
    static String playerTurn = "white";
    public static final int DIMEN = 8;
    
    /**
     * Sets up the chess board squares.
     * @throws IOException if setup fails
     */
    public void setupBoard() throws IOException {
        this.setLayout(new GridLayout(DIMEN, DIMEN));
        for (int y = 0; y < DIMEN; y++) {
            for (int x = 0; x < DIMEN; x++) {
                //creates new square object
                squareList[x][y] = new Square(x, y);
                //adds a panel to the board
                this.add(squareList[x][y]);
                if ((x + y) % 2 == 1) {
                    squareList[x][y].setBackground(new Color(130, 65, 0));
                }
                if ((x + y) % 2 == 0) {
                    squareList[x][y].setBackground(new Color(210, 125, 35));
                }
                squareList[x][y].addMouseListener(new SquareListener());
            }
        }
    }
    /**
     * Creates listener for the squares.
     */
    public class SquareListener extends MouseAdapter {
        Color origColor;
        
        /**
         * Gets the piece from a square and places it onto another square.
         */
        public void mouseClicked(MouseEvent ex) {
            Square sourcePanel = (Square)ex.getSource();
            //if no piece is selected and the square contains a piece,
            //then pick up the piece and remove it from the square.
            if ((heldPiece == null) && (sourcePanel.getPiece() != null)) {
                if (playerTurn.equals(sourcePanel.getPiece().getColor())) {
                    heldPiece = sourcePanel.getPiece();
                    sourcePanel.removePiece();
                }
            } else if (heldPiece != null) {  //while holding a piece
                //if clicked square is in range for the held piece
                if ((heldPiece.inRange(sourcePanel.x, sourcePanel.y) == 1) 
                        && (pathClear(sourcePanel.x, sourcePanel.y) == 1)) {
                    //if clicked square is empty
                    if ((sourcePanel.getPiece() == null)) {
                        sourcePanel.placePiece(heldPiece);
                        if (heldPiece.getColor().equals("white")) {
                            playerTurn = "black";
                        } else if (heldPiece.getColor().equals("black")) {
                            playerTurn = "white";
                        }
                        heldPiece = null;
                        Menu.refreshMenu();
                        //if new square is not empty and the piece color is different
                    } else if ((sourcePanel.getPiece() != null)
                            && (sourcePanel.getPiece().getColor() != heldPiece.getColor())) {
                        sourcePanel.getPiece().remove();
                        sourcePanel.removePiece();
                        sourcePanel.placePiece(heldPiece);
                        if (heldPiece.getColor() == "white") {
                            playerTurn = "black";
                        } else if (heldPiece.getColor().equals("black")) {
                            playerTurn = "white";
                        }
                        heldPiece = null;
                        Menu.refreshMenu();
                    }
                } else if (heldPiece.inRange(sourcePanel.x, sourcePanel.y) == 0) {
                    sourcePanel.placePiece(heldPiece);
                    heldPiece = null;
                }
            }
        }
        
        /**
         * Changes square color on mouseover.
         */
        public void mouseEntered(MouseEvent ex) {
            Object sourcePanel = ex.getSource();
            origColor = ((JPanel)sourcePanel).getBackground();
            if (heldPiece != null) {
                ((JPanel) sourcePanel).setBackground(new Color(245,170,95));
            } else {
                ((JPanel) sourcePanel).setBackground(new Color(145,100,60));
            }
        }
        
        /**
         * Changes square back to original color on mouseexiting.
         */
        public void mouseExited(MouseEvent ex) {
            Object sourcePanel = ex.getSource();
            ((JPanel) sourcePanel).setBackground(origColor);
        }
    }
    
    /**
     * Adds first row of white pieces to the board (Color, x, y, pieceID).
     */
    public void setupWhiteRow1() {
        King whiteKing = new King("white", 4, 0, 1);
        squareList[4][7].placePiece(whiteKing);
        Queen whiteQueen = new Queen("white", 3, 0, 1);
        squareList[3][7].placePiece(whiteQueen);
        Bishop whiteBishop1 = new Bishop("white", 2, 7, 1);
        squareList[2][7].placePiece(whiteBishop1);
        Bishop whiteBishop2 = new Bishop("white", 5, 7, 2);
        squareList[5][7].placePiece(whiteBishop2);
        Knight whiteKnight1 = new Knight("white", 1, 7, 1);
        squareList[1][7].placePiece(whiteKnight1);
        Knight whiteKnight2 = new Knight("white", 6, 7, 2);
        squareList[6][7].placePiece(whiteKnight2);
        Rook whiteRook1 = new Rook("white", 0, 7, 1);
        squareList[0][7].placePiece(whiteRook1);
        Rook whiteRook2 = new Rook("white", 7, 7, 2);
        squareList[7][7].placePiece(whiteRook2);        
    }
    
    /**
     * Adds second row of white pieces to the board (Color, x, y, pieceID).
     */
    public void setupWhiteRow2() {
        
        Pawn whitePawn1 = new Pawn("white", 0, 6, 1);
        squareList[0][6].placePiece(whitePawn1);
        Pawn whitePawn2 = new Pawn("white", 1, 6, 2);
        squareList[1][6].placePiece(whitePawn2);
        Pawn whitePawn3 = new Pawn("white", 2, 6, 3);
        squareList[2][6].placePiece(whitePawn3);
        Pawn whitePawn4 = new Pawn("white", 3, 6, 4);
        squareList[3][6].placePiece(whitePawn4);
        Pawn whitePawn5 = new Pawn("white", 4, 6, 5);
        squareList[4][6].placePiece(whitePawn5);
        Pawn whitePawn6 = new Pawn("white", 5, 6, 6);
        squareList[5][6].placePiece(whitePawn6);
        Pawn whitePawn7 = new Pawn("white", 6, 6, 7);
        squareList[6][6].placePiece(whitePawn7);
        Pawn whitePawn8 = new Pawn("white", 7, 6, 8);
        squareList[7][6].placePiece(whitePawn8);
    }
    
    /**
     * Adds first row of black pieces to the board (Color, x, y, pieceID).
     */
    public void setupBlackRow1() {
        King blackKing = new King("black", 4, 0, 1);
        squareList[4][0].placePiece(blackKing);
        Queen blackQueen = new Queen("black", 3, 0, 1);
        squareList[3][0].placePiece(blackQueen);
        Bishop blackBishop1 = new Bishop("black", 2, 0, 1);
        squareList[2][0].placePiece(blackBishop1);
        Bishop blackBishop2 = new Bishop("black", 5, 0, 2);
        squareList[5][0].placePiece(blackBishop2);
        Knight blackKnight1 = new Knight("black", 1, 0, 1);
        squareList[1][0].placePiece(blackKnight1);
        Knight blackKnight2 = new Knight("black", 6, 0, 2);
        squareList[6][0].placePiece(blackKnight2);        
        Rook blackRook1 = new Rook("black", 0, 0, 1);
        squareList[0][0].placePiece(blackRook1);
        Rook blackRook2 = new Rook("black", 7, 0, 2);
        squareList[7][0].placePiece(blackRook2);
    }
    
    /**
    * Adds second row of black pieces to the board (Color, x, y, pieceID).
    */
    public void setupBlackRow2() {
        Pawn blackPawn1 = new Pawn("black", 0, 6, 1);
        squareList[0][1].placePiece(blackPawn1);
        Pawn blackPawn2 = new Pawn("black", 1, 6, 2);
        squareList[1][1].placePiece(blackPawn2);
        Pawn blackPawn3 = new Pawn("black", 2, 6, 3);
        squareList[2][1].placePiece(blackPawn3);
        Pawn blackPawn4 = new Pawn("black", 3, 6, 4);
        squareList[3][1].placePiece(blackPawn4);
        Pawn blackPawn5 = new Pawn("black", 4, 6, 5);
        squareList[4][1].placePiece(blackPawn5);
        Pawn blackPawn6 = new Pawn("black", 5, 6, 6);
        squareList[5][1].placePiece(blackPawn6);
        Pawn blackPawn7 = new Pawn("black", 6, 6, 7);
        squareList[6][1].placePiece(blackPawn7);
        Pawn blackPawn8 = new Pawn("black", 7, 6, 8);
        squareList[7][1].placePiece(blackPawn8);
    }
    
    /**
     * Checks the squares that a piece would move through in order to
     * get to it's destination square.
     * @param nextX as an int
     * @param nextY as an int
     * @return 1 if path clear, 0 if not
     */
    int pathClear(int nextX, int nextY) {
        int xcounter = 0;
        int ycounter = 0;
        int xcoordCheck = heldPiece.xcoord;
        int ycoordCheck = heldPiece.ycoord;
        
        if (heldPiece.getType().equals("knight")) {
            return 1;
        }
        if (xcoordCheck > nextX) {
            xcounter = -1;
        } else if (xcoordCheck < nextX) {
            xcounter = 1;
        }
        if (ycoordCheck > nextY) {
            ycounter = -1;
        } else if (ycoordCheck < nextY) {
            ycounter = 1;
        }
        //moves the checker one space on each axis until it hits the
        //destination point on each axis or finds a piece on the square
        while ((xcoordCheck != nextX) || (ycoordCheck != nextY)) {
            if (squareList[xcoordCheck][ycoordCheck].getPiece() != null) {
                return 0;
            }
            if (xcoordCheck != nextX) {
                xcoordCheck = xcoordCheck + xcounter;
            }
            if (ycoordCheck != nextY) {
                ycoordCheck = ycoordCheck + ycounter;
            }
        }
        return 1;
    }
    
    /**
     * Places the pieces on the board and re-adds mouse after opening
     * a previously saved game.
     */
    void loadPieces() {
        this.setLayout(new GridLayout(DIMEN, DIMEN));
        for (int i = 0; i < DIMEN; i++) {
            for (int j = 0; j < DIMEN; j++) {
                if (squareList[j][i].getPiece() != null) {
                    squareList[j][i].placePiece();
                    squareList[j][i].addMouseListener(new SquareListener());
                    this.add(squareList[j][i]);
                    
                } else if (squareList[j][i].getPiece() == null) {
                    squareList[j][i].addMouseListener(new SquareListener());
                    this.add(squareList[j][i]);
                }
            }
        }
    }
    
    /**
     * Writes to a file the array containing all the pieces and the variable
     * containing which player's turn it is.
     */
    public static void serialWrite() {
        try {
            FileOutputStream f1 = new FileOutputStream("src/savegames/chess.gam");
            ObjectOutputStream out = new ObjectOutputStream(f1);
            out.writeObject(squareList);
            out.writeObject(playerTurn);
            out.flush();
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Reads from a file the array containing all the pieces and their
     * positions, and the player turn.
     */
    public static void serialRead() {
        try {
            FileInputStream f2 = new FileInputStream("src/savegames/chess.gam");
            ObjectInputStream in = new ObjectInputStream(f2);
            squareList = (Square[][]) in.readObject();
            playerTurn = (String) in.readObject();
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}