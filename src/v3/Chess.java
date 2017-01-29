package v3;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Chess extends JPanel {
    private static JFrame frame;
    private JList<String> blackList;
    private JList<String> whiteList;
    
    public Chess() {
        super(new BorderLayout());
        JPanel leftPanel = createVerticalBoxPanel();
        JPanel rightPanel = createVerticalBoxPanel();
        
        JPanel whitePanel = new JPanel(new BorderLayout());
        DefaultListModel<String> listModel = new DefaultListModel<String>();
        listModel.addElement("Bishop");
        listModel.addElement("Queen");
        listModel.addElement("Bishop");
        listModel.addElement("Pawn");
        listModel.addElement("Pawn");
        listModel.addElement("Pawn");
        listModel.addElement("Pawn");
        whiteList = new JList<String>(listModel);
        whiteList.setVisibleRowCount(-1);
        JScrollPane whiteListView = new JScrollPane(whiteList);
        whiteListView.setPreferredSize(new Dimension(200,100));
        whitePanel.add(whiteListView, BorderLayout.EAST);
        whitePanel.setBorder(BorderFactory.createTitledBorder("List of White Pieces"));
        rightPanel.add(whitePanel);
        this.add(rightPanel);
        
        JPanel blackPanel = new JPanel(new BorderLayout());
        DefaultListModel<String> blackTaken = new DefaultListModel<String>();
        blackTaken.addElement("Bishop");
        blackTaken.addElement("Queen");
        blackTaken.addElement("Bishop");
        blackTaken.addElement("Pawn");
        blackTaken.addElement("Pawn");
        blackTaken.addElement("Pawn");
        blackTaken.addElement("Pawn");
        blackList = new JList<String>(blackTaken);
        blackList.setVisibleRowCount(-1);
        JScrollPane blackListView = new JScrollPane(blackList);
        blackListView.setPreferredSize(new Dimension(200,100));
        
        //blackPanel.add((blackListView, BorderLayout.WEST));
        blackPanel.setBorder(BorderFactory.createTitledBorder("List of Black Pieces"));
        leftPanel.add(blackPanel);        
        this.add(leftPanel);
        }
    
    protected JPanel createVerticalBoxPanel() {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
        p.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        return p;
    }
    
    private static void createGUI() {
        frame = new JFrame("Chess");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JComponent newContentPane = new Chess();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);   
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });

    }
}
