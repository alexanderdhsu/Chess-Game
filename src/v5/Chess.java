package v5;

import java.io.IOException;
import javax.swing.JFrame;

public class Chess {

    public static void main(String[] args) throws IOException {
        MainPanel panel = new MainPanel();
        JFrame frame = new JFrame("MainPanel");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setPanelPreferences();
        panel.setupBoard();
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}