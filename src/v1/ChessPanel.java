package v1;

import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class ChessPanel extends JPanel {
    private String playerName;
    private boolean firstTurn = false;
    
    
    //ArrayList<Point> white = new ArrayList<Point>();
    //private Point rook = new Point(75, 75);
    
    // boolean test = white.add("thing");

    /**
     * constructor
     */
    public ChessPanel(){
    }
    public void setPanelPreferences() {
        setBackground(Color.white);
        setPreferredSize(new Dimension(500,500));
        setFont(new Font("Arial", Font.BOLD, 16));
    }
    public void paintComponent(Graphics page){
        super.paintComponent(page);
        
        page.setColor(Color.black);
        page.drawString("2-Player Chess", 190, 25);
        page.drawRect(50, 50, 400, 400);
        page.fillRect(50, 100, 50, 50);
        page.fillRect(50, 200, 50, 50);
        page.fillRect(50, 300, 50, 50);
        page.fillRect(50, 400, 50, 50);
        page.fillRect(100, 50, 50, 50);
        page.fillRect(100, 150, 50, 50);
        page.fillRect(100, 250, 50, 50);
        page.fillRect(100, 350, 50, 50);
        page.fillRect(150, 100, 50, 50);
        page.fillRect(150, 200, 50, 50);
        page.fillRect(150, 300, 50, 50);
        page.fillRect(150, 400, 50, 50);
        page.fillRect(200, 50, 50, 50);
        page.fillRect(200, 150, 50, 50);
        page.fillRect(200, 250, 50, 50);
        page.fillRect(200, 350, 50, 50);
        page.fillRect(250, 100, 50, 50);
        page.fillRect(250, 200, 50, 50);
        page.fillRect(250, 300, 50, 50);
        page.fillRect(250, 400, 50, 50);
        page.fillRect(300, 50, 50, 50);
        page.fillRect(300, 150, 50, 50);
        page.fillRect(300, 250, 50, 50);
        page.fillRect(300, 350, 50, 50);
        page.fillRect(350, 100, 50, 50);
        page.fillRect(350, 200, 50, 50);
        page.fillRect(350, 300, 50, 50);
        page.fillRect(350, 400, 50, 50);
        page.fillRect(400, 50, 50, 50);
        page.fillRect(400, 150, 50, 50);
        page.fillRect(400, 250, 50, 50);
        page.fillRect(400, 350, 50, 50);
        
    }
    /**
     * 
     */
    public void setName(String nameInput){
        playerName = nameInput;
    }
    /**
     * 
     */
    public String getName(){
        return playerName;
    }
    
    /**
     * @param
     */
    public void setFirstMove(boolean firstMoveInput){
        firstTurn = firstMoveInput;
    }
    /**
     * @return
     */
    public boolean getFirstMove(){
        return firstTurn;
    }
}
