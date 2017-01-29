package v5;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;

import javax.swing.*;
import javax.swing.table.*;
import java.io.IOException;

@SuppressWarnings("serial")
public class MainPanel extends JPanel 
{
    
    public JPanel[][] Coordinates = new JPanel[8][8];
    
    public MainPanel() {
        this.setLayout(new BorderLayout());
    }
    
    public boolean canImport(TransferHandler.TransferSupport info) {
        // for the demo, we will only support drops (not clipboard paste)
        if (!info.isDrop()) {
            return false;
        }

        // fetch the drop location
        JTable.DropLocation dl = (JTable.DropLocation)info.getDropLocation();

        int column = dl.getColumn();

        // we do not support invalid columns or the first column
        if (column == -1 || column == 0) {
            return false;
        }

        return true;
    }
    
    public void setPanelPreferences() {
        setBackground(Color.white);
        setPreferredSize(new Dimension(1000,1000));
        setFont(new Font("Arial", Font.BOLD, 16));
    }
    
    public void setupBoard() throws IOException {
        Pieces king = new Pieces(true);
        JPanel block = new JPanel();
        
        String[] columnNames = {"one", "two"};
        Object[][] squares = {
                {king, king},
                {king, king},
                { , },
                {block,block},
        };
        
        DefaultTableModel model = new DefaultTableModel(squares, columnNames);
        JTable board = new JTable(model);
        board.setDragEnabled(true);
        
        
        /*board.setLayout(new GridLayout(8,8));
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
        }*/
        this.add(board, BorderLayout.CENTER);
    }
}