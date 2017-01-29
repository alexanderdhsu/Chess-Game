package v2;

/**
 * 
 */

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ChessBoard extends JPanel {
    private final int ROW = 8;
    private final int COL = 8;
    public int[][] Coordinates = new int[8][8];

    /**
     * constructor
     */
    public ChessBoard() {
    	//Sets BorderLayout for the chess interface panel
    	this.setLayout(new BorderLayout());
    	
    	//Sets the panel holding the chessboard
        JPanel board = new JPanel();
        board.setLayout(new GridLayout(ROW, COL));
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
        JButton b10 = new JButton("10");
        JButton b11 = new JButton("11");
        JButton b12 = new JButton("12");
        JButton b13 = new JButton("13");
        JButton b14 = new JButton("14");
        JButton b15 = new JButton("15");
        JButton b16 = new JButton("16");
        JButton b17 = new JButton("17");
        JButton b18 = new JButton("18");
        JButton b19 = new JButton("19");
        
        board.add(b1);
        board.add(b2);
        board.add(b3);
        board.add(b4);
        board.add(b5);
        board.add(b6);
        board.add(b7);
        board.add(b8);
        board.add(b9);
        board.add(b10);
        board.add(b11);
        board.add(b12);
        board.add(b13);
        board.add(b14);
        board.add(b15);
        board.add(b16);
        board.add(b17);
        board.add(b18);
        board.add(b19);
        
        this.add(board, BorderLayout.CENTER);
        
        //Adds title to interface
        JLabel title = new JLabel("This is a chess game.");
        this.add(title, BorderLayout.NORTH);
        
        //Adds info to west panel - black side
        JLabel blackside = new JLabel("   Black");
        this.add(blackside, BorderLayout.WEST);
        
      //Adds info to east panel - white side
        JLabel whiteside = new JLabel("White   ");
        this.add(whiteside, BorderLayout.EAST);
    }
}