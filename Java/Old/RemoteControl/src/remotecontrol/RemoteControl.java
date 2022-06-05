/*
* This program use the java.awt and javax.swing classes to create a GUI
* of a simple-designed universal remote control.
*/
package remotecontrol;

/**
 *
 * @author user
 */
import java.awt.*;
import javax.swing.*;
public class RemoteControl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Creates a container for the remote control
        JFrame remoteC = new JFrame();
        //Creates a GridLayout for the remote control
        /*The row is set 0 because the components
        * are added from from top to bottom if I
        * if I have something like GridLayout(8, 3)
        * I want the components to add left to right.
        */
        remoteC.setLayout(new GridLayout(0, 3));
        
        /*From here on, the components are added
        * from left to right.
        * 3 components are filled on each row
        * before components begin on a new row.
        */
        JButton powButton = new JButton("Power");
        remoteC.add(powButton);
        
        JLabel emptyLabel1 = new JLabel("");
        remoteC.add(emptyLabel1);
        
        JButton tvInput = new JButton("Tv/Input");
        remoteC.add(tvInput);
        
        JButton volumeUp = new JButton("+");
        remoteC.add(volumeUp);
        
        JButton mute = new JButton("Mute");
        remoteC.add(mute);
        
        JButton upArrow = new JButton("↑");
        remoteC.add(upArrow);
        
        JLabel volume = new JLabel("     Volume");
        remoteC.add(volume);
            
        JButton enter = new JButton("Enter");
        remoteC.add(enter);
        
        JLabel channel = new JLabel("     Channel");
        remoteC.add(channel);
        
        JButton volumeDown = new JButton("-");
        remoteC.add(volumeDown);
                
        JLabel emptyLabel2 = new JLabel("");
        remoteC.add(emptyLabel2);
        
        JButton downArrow = new JButton("↓");
        remoteC.add(downArrow);
        
        //Array for the loop that will create
        //number buttons.
        JButton[] numButton = new JButton[10];
        
        for (int i = 1; i < 10; i++)
        {
            numButton[i] = new JButton(i + "");
            remoteC.add(numButton[i]);
        }// end numButton loop
        
        JButton menu = new JButton("Menu");
        remoteC.add(menu);
        
        JButton num0 = new JButton("0");
        remoteC.add(num0);
        
        JButton exit = new JButton("Exit");
        remoteC.add(exit);
        
        remoteC.setTitle("Remote Control");
        remoteC.setSize(250, 500);
        remoteC.setLocation(200, 100);
        remoteC.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        remoteC.setVisible(true); 
                
    }// end Main()
    
}// end RemoteControl class
