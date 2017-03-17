package ca.bcit.comp2526.a2a;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * GUI class that contains a side menu displaying the game title,
 * the current turn, a placeholder for the score, and a button to
 * save the game.
 * @author Alex
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Menu extends JPanel {
    private static JLabel title;
    private static JLabel turn;
    private static JLabel score;
    private static JLabel save;
    
    /**
     * Constructor for the side menu GUI.
     */
    Menu() {
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(145,100,60));
        
        JPanel titleDisplay = new JPanel();
        GridBagConstraints aconstr = new GridBagConstraints();
        titleDisplay.setBackground(new Color(210, 125, 35));
        aconstr.ipadx = 100;
        aconstr.ipady = 50;
        aconstr.gridy = 1;
        this.add(titleDisplay, aconstr);
        title = new JLabel("Chess");
        title.setFont(new Font("Verdana", 1, 40));
        titleDisplay.add(title);  
        
        JPanel blankPanel1 = new JPanel();
        GridBagConstraints bconstr = new GridBagConstraints();
        blankPanel1.setBackground(new Color(145,100,60));
        bconstr.ipadx = 370;
        bconstr.ipady = 10;
        bconstr.gridy = 2;
        this.add(blankPanel1, bconstr);
        
        JPanel turnDisplay = new JPanel();
        GridBagConstraints cconstr = new GridBagConstraints();
        turnDisplay.setBackground(new Color(210, 125, 35));
        cconstr.ipadx = 220;
        cconstr.ipady = 120;
        cconstr.gridy = 3;
        this.add(turnDisplay, cconstr);
        turn = new JLabel("White's turn");
        turn.setFont(new Font("Verdana", 1, 20));
        turnDisplay.add(turn);
        
        JPanel blankPanel2 = new JPanel();
        blankPanel2.setBackground(new Color(145,100,60));
        bconstr.ipady = 155;
        bconstr.gridy = 4;
        this.add(blankPanel2, bconstr);
        
        JPanel scoreDisplay = new JPanel();
        GridBagConstraints dconstr = new GridBagConstraints();
        scoreDisplay.setBackground(new Color(210, 125, 35));
        dconstr.ipadx = 220;
        dconstr.ipady = 140;
        dconstr.gridy = 5;
        this.add(scoreDisplay, dconstr);
        score = new JLabel("Score");
        score.setFont(new Font("Verdana", 1, 30));
        scoreDisplay.add(score);
        
        JPanel blankPanel3 = new JPanel();
        blankPanel3.setBackground(new Color(145,100,60));
        bconstr.ipady = 10;
        bconstr.gridy = 6;
        this.add(blankPanel3, bconstr);
        
        JPanel saveDisplay = new JPanel();
        GridBagConstraints econstr = new GridBagConstraints();
        saveDisplay.setBackground(new Color(210, 125, 35));
        econstr.ipadx = 70;
        econstr.ipady = 50;
        econstr.gridy = 7;
        this.add(saveDisplay, econstr);
        save = new JLabel("Click to Save");
        save.setFont(new Font("Verdana", 1, 30));
        save.addMouseListener(new SaveListener());
        saveDisplay.add(save);
    }
    
    /**
     * Changes the menu text back to the default after each move,
     * and changes the turn counter to reflect the current player.
     */
    public static void refreshMenu() {
        if (Board.playerTurn.equals("white")) {
            turn.setText("White's turn");
            save.setText("Click to Save");
        } else {
            turn.setText("Black's turn");
            save.setText("Click to Save");
        }
    }
    
    /**
     * Listens to the board and saves the game if the JLabel in
     * saveDisplay is clicked on.
     *
     */
    private class SaveListener extends MouseAdapter {
        public void mouseClicked(MouseEvent ex) {
            Board.serialWrite();
            save.setText("Game Was Saved!");
        }
    }
}