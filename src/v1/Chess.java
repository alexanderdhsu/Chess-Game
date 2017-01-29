package v1;

import java.util.Scanner;
import java.util.Random;
import javax.swing.JFrame;

/**
 * Current State:
 * - one object for each player
 * - an object for the chess actions
 * - an object for the chessboard visual
 * 
 * To Do:
 * - create coordinate system
 * - create move infrastructure
 * - create drag and drop interface
 * 
 * Questions:
 * - Why wouldn't you use more than two classes? By only using two, the reference class
 * will contain a lot of methods that aren't used by every object, thus cluttering it up.
 * - Should I search for the most efficient ways to code this or try to only use what
 * I know?
 * 
 * 
 * @author Alex Hsu
 * @version 1.1
 */
public class Chess {
    /**
     * <p>Main point of entry for the program.</p>
     * @param args
     */
    public static void main(String[] args) {
        String startChoice;
        
        Scanner scan = new Scanner(System.in);
        Random rand = new Random(1);
        JFrame frame = new JFrame("Chessboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ChessPanel panel = new ChessPanel();
        ChessPanel askShallow = new ChessPanel();
        ChessPanel playerOne = new ChessPanel();
        ChessPanel playerTwo = new ChessPanel();
        
        panel.setPanelPreferences();
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);

        System.out.println("Hello, my name is Shallow Blue. I am a two-player chess program.");
        askShallow.setName("Shallow");
        System.out.print("Please enter the name of player one: ");
        playerOne.setName(scan.next());
        System.out.print("Please enter the name of player two: ");
        playerTwo.setName(scan.next());

        do {
            System.out.print("Hello " + playerOne.getName() + " and " + playerTwo.getName()
                    + ". You can either pick who starts as white or let me decide.\n"
                    + "Type either the name of the player who starts or 'Shallow' to"
                    + " let me choose! \nChoice: ");
            startChoice = scan.next();
            
            if (startChoice.equals("Shallow")){
                int a = rand.nextInt(2);
                if (a == 1){
                    System.out.println(playerOne.getName() + " goes first!");
                    playerOne.setFirstMove(true);
                }
                else {
                    System.out.println(playerTwo.getName() + " goes first!"); 
                    playerTwo.setFirstMove(true);
                    }
                }
            else if (startChoice.equals(playerOne.getName())) {
                System.out.println(playerOne.getName() + " goes first!");
                playerOne.setFirstMove(true);
                }
            else if (startChoice.equals(playerTwo.getName())) {
                System.out.println(playerTwo.getName() + " goes first!");
                playerTwo.setFirstMove(true);
            }
            else
                System.out.println("That is not a valid answer. Pick someone!");
        }
        while((playerOne.getFirstMove() == false) && (playerTwo.getFirstMove() == false));
        
        
        
        
        scan.close();
    }
}
