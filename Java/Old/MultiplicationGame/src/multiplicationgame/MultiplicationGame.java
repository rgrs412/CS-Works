/*
 *This program creates a graphical user interface(GUI) with a JTextField, for 
 *users to enter answers for multiplication questions.
 *
 *Different multiplication questions will be displayed in the output
 *each time the user enters an answer on the GUI. The program ends when
 *the user close the window of the GUI.
 */
package multiplicationgame;

/**
 *
 * Wuheng Yu
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class MultiplicationGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Instantiate the GUI object
        Multiplication mGame = new Multiplication();
                
        mGame.setTitle("Multiplication Game");//set title for GUI
        mGame.setSize(150, 100);// set size for GUI
        mGame.setLocation(200, 100);//set location where GUI appears
        mGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//end program when close

        mGame.setVisible(true);//so the GUI will pop up.
        
    }// end main()
    
}// end MultiplicationGame class

//Create subclass of JFrame named Multiplication
class Multiplication extends JFrame implements ActionListener 
{
    JLabel label = new JLabel("Multiplication Practice");
    JTextField textField = new JTextField(5);
    int random1 = (int)(Math.random() * 10);// random # between 0 and 10
    int random2 = (int)(Math.random() * 10);// random # between 0 and 10
    int x = random1 * random2;//product of the two random #s
    
    //construtor to construct the layout and JTextField, then add them to GUI
    public Multiplication()
    {
        setLayout( new FlowLayout());//set FlowLayout
        
        add(label);//add JLabel onto GUI
        
        textField.setHorizontalAlignment(JTextField.CENTER);
        add(textField);//add JTextField onto GUI
        
        System.out.println("What is " + random1 + " * " + random2 + "?");
        //Multiplication class (this) will be listener for JTextField
        textField.addActionListener(this);
        
    }

    public void actionPerformed(ActionEvent e) 
    {
        String ans = textField.getText();//Assign user input to ans
        textField.setText("");
        int answer = Integer.parseInt(ans);//convert string (ans) to int
        
        if (answer == (x))
        {
            System.out.println("Correct!");  
        }
        else
            System.out.println("Incorrect. The correct answer is " + x);
        
        //infinite loop of multiplication questions
        random1 = (int)(Math.random() * 10);
        random2 = (int)(Math.random() * 10);
        x = random1 * random2;
        System.out.println("What is " + random1 + " * " + random2 + "?");
    }
    
}// end Multiplication class
