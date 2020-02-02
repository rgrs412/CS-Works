package Assignment;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * Graphical Tip Calculator
 * See the CSCI112_A6B.pdf document for details.
 *
 * @author Wuheng Yu
 */
public class TipCalculator {

    public static void main(String[] args) {
        TipCalc tipCalc = new TipCalc("Tip Calculator");
    }
}

class TipCalc extends JFrame implements ActionListener {

    JPanel panel1 = new JPanel();                                               //Main panel
    JPanel panel2 = new JPanel();                                               //panel1 sub-panel
    JPanel panel3 = new JPanel();                                               //panel1 sub-panel
    JPanel panel4 = new JPanel();                                               //panel1 sub-panel
    JPanel panel5 = new JPanel();                                               //panel2 sub-panel
    JPanel panel6 = new JPanel();                                               //panel3 sub-panel
    JPanel panel7 = new JPanel();                                               //panel3 sub-panel
    JPanel panel8 = new JPanel();                                               //panel3 sub-panel
    JLabel label1 = new JLabel("Enter the bill amount: ");                 //JLabel for bill amount
    JLabel label2 = new JLabel("Tip Percentage: ");                        //JLabel for Tip Percentage
    JLabel label3 = new JLabel("Tip Amount: ");                            //JLabel for Tip Amount
    JLabel label4 = new JLabel("Total Amount: ");                          //JLabel for Total Amount
    JTextField textField1 = new JTextField(5);                          //JTextField to enter the bill amount
    JButton button1 = new JButton("Calculate Tip");                        //JButton to calculate Tip Amount
    JButton button2 = new JButton("Reset");                                //JButton to reset GUI components to default
    JSlider slider1 = new JSlider(JSlider.HORIZONTAL,0,50,30); //JSlider for Tip Percentage

    public TipCalc(String titleIn) {
        super.setTitle(titleIn);                                                //set title for GUI
        super.setSize(300, 250);                                  //set size for GUI
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                   //end program when closed

        super.add(panel1);                                                      //add panel1 to JFrame
        panel1.setLayout(new BorderLayout());                                   //set panel1 layout to BorderLayout
        panel1.add(panel2, BorderLayout.NORTH);                                 //add panel2 to North Border of panel1
        panel1.add(panel3, BorderLayout.CENTER);                                //add panel3 to Center Border of panel1
        panel1.add(panel4, BorderLayout.SOUTH);                                 //add panel4 to South Border of panel1
        panel2.add(panel5);                                                     //add panel5 to panel2
        panel5.add(label1);                                                     //add label1 to panel5
        panel5.add(textField1);                                                 //add textField1 to panel5

        panel3.setLayout(new BorderLayout());                                   //set panel3 layout to BorderLayout
        panel3.add(panel6, BorderLayout.NORTH);                                 //add panel6 to North Border of panel3
        panel3.add(panel7, BorderLayout.CENTER);                                //add panel7 to Center Border of panel3
        panel3.add(panel8, BorderLayout.SOUTH);                                 //add panel8 to South Border of panel3
        panel6.add(label2);                                                     //add label2 to panel6
        label2.setBorder(new EmptyBorder(0,0,0,100));   //adjust position of label2
        panel7.add(slider1);                                                    //add slider1 to panel7
        slider1.setLocation(0,100);                                       //adjust position of slider1
        slider1.setMajorTickSpacing(10);                                        //Slider have a Major Tick at 0,10,20... so on
        slider1.setMinorTickSpacing(2);                                         //Slider have 4 minor ticks between each Major Tick
        slider1.setPaintTicks(true);                                            //Makes Ticks visible
        slider1.setPaintLabels(true);                                           //Makes Major Tick values visible
        panel8.setLayout(new GridLayout(2,1));                       //set panel8 layout to GridLayout(2 rows, 1 column)
        panel8.add(label3);                                                     //add label3 to panel8
        label3.setBorder(new EmptyBorder(0,50,10,0));   //adjust label3 position
        panel8.add(label4);                                                     //add label4 to panel8
        label4.setBorder(new EmptyBorder(0,50,10,0));   //adjust label4 position

        panel4.add(button1);                                                    //add button1 to panel4
        panel4.add(button2);                                                    //add button2 to panel4

        textField1.addActionListener(this);                                  //TipCalc class(this) will act as the listener
        button1.addActionListener(this);
        button2.addActionListener(this);

        button1.setActionCommand("1");
        button2.setActionCommand("2");


        super.setVisible(true);                                                 //Display the GUI
    }

    public void actionPerformed(ActionEvent e) {
        String answer1;                                                         //String input for bill amount
        double bill;                                                            //answer1 parseDouble
        double tipAmount;                                                       //tipAmount is (bill * (tip percentage / 100))
        double totalAmount;                                                     //total amount is (bill + tip amount)
        String formattedTipAmount;                                              //formatted tipAmount to 2 decimal places
        String formattedTotalAmount;                                            //formatted totalAmount to 2 decimal places
        double currentValue;                                                    //value of tip percentage on slider1

        if(e.getActionCommand().equals("1")) {                                  //Executes if button1 is pressed
            answer1 = textField1.getText();
            bill = Double.parseDouble(answer1);
            currentValue = slider1.getValue();

            tipAmount = bill * (currentValue / 100);
            formattedTipAmount = String.format("%.2f", tipAmount);

            totalAmount = bill + tipAmount;
            formattedTotalAmount = String.format("%.2f", totalAmount);

            label3.setText("Tip Amount: $" + formattedTipAmount);               //Show Tip Amount on GUI
            label4.setText("Total Amount: $" + formattedTotalAmount);           //Show Total Amount on GUI
        }
        else if(e.getActionCommand().equals("2")) {                             //Executes if button2 is pressed
            slider1.setValue(30);
            textField1.setText("");
            label3.setText("Tip Amount: ");
            label4.setText("Total Amount: ");
        }
    }

}
