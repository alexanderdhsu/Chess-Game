package v4;

import java.awt.*;
import javax.swing.*;
import java.io.IOException;

@SuppressWarnings("serial")
public class MainPanel extends JPanel 
{
    public JPanel[][] Coordinates = new JPanel[8][8];
    
    public MainPanel() {
        this.setLayout(new BorderLayout());
    }
    
    public void setPanelPreferences() {
        setBackground(Color.white);
        setPreferredSize(new Dimension(1000,1000));
        setFont(new Font("Arial", Font.BOLD, 16));
    }
    
    public void setupBoard() throws IOException {
        JPanel board = new JPanel();
        board.setLayout(new GridLayout(8,8));
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                Coordinates[x][y] = new JPanel();
                Coordinates[x][y].setLayout(new FlowLayout());
                board.add(Coordinates[x][y]);
                if ((x%2 == 1) && (y%2 == 0)) {
                    Coordinates[x][y].setBackground(Color.black);
                }
                if ((x%2 == 0) && (y%2 == 1)) {
                    Coordinates[x][y].setBackground(Color.black);
                }
            }
        }
        
        /**Attempt to create custom JLabel class that is draggable**/
        DnDLabel label = new DnDLabel("Test Label");
        Coordinates[1][1].add(label);
        
        this.add(board, BorderLayout.CENTER);
        
        /**Attempt to add image to JPanel**/
        /*BufferedImage King = ImageIO.read(new File("src/images/kingBlack.png"));
        JLabel kingLabel = new JLabel(new ImageIcon(King));
        Squares[4][0].add(kingLabel);*/
        /**Attempt to add a draggable button on top of a square**/
        /*JButton button = new JButton("this is the test");
        TransferHandler transfer = new TransferHandler("test");
        button.setTransferHandler(transfer);
        button.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                JButton button = (JButton)e.getSource();
                TransferHandler handle = button.getTransferHandler();
                handle.exportAsDrag(button, e, TransferHandler.COPY);
            }
        });
        Squares[2][0].add(button);*/
        /**Attempt to add a customized button class that is draggable**/
        /*DnDButton button = new DnDButton("This is a test");
        Squares[1][0].add(button);
        DnDButton button2 = new DnDButton("This is another test");
        Squares[6][0].add(button2);*/
        /**Attempt to do something.**/
        /*JLabel king = new JLabel("King");
        Squares[4][0].add(king);
        JLabel queen = new JLabel("Queen");
        queen.setForeground(Color.white);
        Squares[3][0].add(queen);
        Squares[3][0].setEnabled(true);
        Squares[3][0].setTransferHandler(new ListTransferHandler());*/
    }
    
    public boolean canImport(TransferHandler.TransferSupport info) {
         return true;
    }
    
    public boolean importData(TransferHandler.TransferSupport info) {
        return true;
    }
}