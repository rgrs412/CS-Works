/*This program guides the users to enter valid password.
*
*If the entered password is not valid or doesn't follow the valid password rules,
*the program will state why the entered password is invalid. This process will
*loop if a continue to enter invalid words.
*
*The program will perform an automated check of each type of password 
*validation at the beginning. This is done by reading a text data file
*called "passwords.txt" that consist of all the invalid password types 
*and one valid password.
*/
package pwcheck;

/**
 *
 * Wuheng Yu
 */
import java.io.File;
import java.util.Scanner;
public class PwCheck {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception
    {
    String pw;// User input of password
    String pw1;// Trimmed password
    String pw0;// User confirmation of password
    String pw2;// Trimmed confirmed password
    
    // The follow variables will store 'true' or 'false'.
    boolean valLength;
    boolean valNum;
    boolean valUpperC;
    boolean valSpace;
    boolean valFirstChar;
    String[] pwCheck = new String[6]; //Array to store data from "passwords.txt)
    
    Scanner inputD = new Scanner(System.in);
    
    /*Calls automatedCheck method to read "passwords.txt" and validate
    *each of the passwords read from the txt file.
    *
    *The automated check will serve as a guide for the users to enter a 
    *valid password.
    */
    automatedCheck(pwCheck);
    
    //prompt users to enter a password.
    System.out.print("Enter your password: ");
    pw = inputD.nextLine();
    pw1 = pw.trim();
    
    //Calls methods to validate entered password.
    valLength = pwLength(pw1); //Validate password length
    valNum = numCheck(pw1);//Validate password contain at least one number
    valUpperC = upperCCheck(pw1);//Validate password contain one uppercase letter
    valSpace = spaceCheck(pw1);//Validate password does not contain spaces
    valFirstChar = firstChar(pw1);//Validate first password character is not '!' or '?'
    
    /*This loop will prompt the user to enter a valid password if the previous
    *entered password is invalid. Loop will continue as long as password 
    *entered is invalid.
    */
    while (true)
        //if statement will activate if the entered password is valid.
        if ((valLength == true) && (valNum == true) && (valUpperC == true) 
                && (valSpace == true) && (valFirstChar == true))
        {
            System.out.print("Confirm your password: ");
            pw0 = inputD.nextLine();
            pw2 = pw0.trim();
            //if statement confirm the passwords entered.
            if ( pw2.equals(pw1) )
            {
                System.out.println("Success! Password is created.");
                break;//Break out of while loop since the passwords match.
            }
            else
                System.out.println("Passwords doesn't match.");
        }
        /*else statement to prompt user to enter a valid password after previous
        *entered password is invalid.
        */
        else
        {
        System.out.println("");
        System.out.println("Password invalid. Enter a valid password");
        System.out.print("Enter your password: ");
        
        pw = inputD.nextLine();
        pw1 = pw.trim();
        System.out.println("");

        valLength = pwLength(pw1); 
        valNum = numCheck(pw1);
        valUpperC = upperCCheck(pw1);
        valSpace = spaceCheck(pw1);
        valFirstChar = firstChar(pw1);
        }//end of loop
        
    }// end main()
/******************************************************************************/
    /*
    *This method checks that password length is at least 8 characters long.
    */
    public static boolean pwLength(String p1) 
    {
    if (p1.length() > 7)
        return true;
    else
        System.out.println("-The password needs to be at least 8 characters long.");
        return false;
    }// end pwLength()
/******************************************************************************/
    /*
    *This method checks that password contain atleast one numerical digit.
    */
    public static boolean numCheck(String p1)
    {
    boolean hasNum = false;//Remain false if no digit.
    int i;//Array element
    char d;//variable for each character in string
    
    //Loop to check if any of the characters is a digit
    for (i = 0; i < p1.length(); i++)
    {
        d = p1.charAt(i);
        if (Character.isDigit(d))
        {
            hasNum = true; //Has a digit
            break;
        }
    }    
    if (hasNum == false)
        System.out.println("-The password must contain a digit.");
    
    return hasNum;
    }// end numCheck()
/******************************************************************************/
    /*
    *This method checks to see if password has at least one uppercase letter.
    */
    public static boolean upperCCheck(String p1) 
    {
    boolean hasUpperC = false;//remain false if no uppercase letter
    int i;
    char d;
    
    for (i = 0; i < p1.length(); i++)
    {
        d = p1.charAt(i);
        if (Character.isUpperCase(d))
        {
            hasUpperC = true;
            break;
        }
    }    
    if (hasUpperC == false)
        System.out.println("-The password must contain an uppercase letter.");
    
    return hasUpperC;
    }// end upperCCheck()
/******************************************************************************/
    /*
    *This method verify if there are spaces or not in the password.
    */
    public static boolean spaceCheck(String p1) 
    {
    boolean noSpace = true;//remain true if there are no spaces
    int i;
    char d;
    
    for (i = 0; i < p1.length(); i++)
    {
        d = p1.charAt(i);
        if (Character.isWhitespace(d))
        {
            noSpace = false;//Password contains spaces.
            break;
        }
    }    
    if (noSpace == false)
        System.out.println("-The password must not contain white spaces.");
    
    return noSpace;
    }// end spaceCheck()
/*****************************************************************************/
    /*
    *This method checks if the first character of password is '!' or '?'
    */
    public static boolean firstChar(String p1) 
    {
    if ( (p1.charAt(0) == '!') || (p1.charAt(0) == '?') )
    {
        System.out.println("-The password must not begin with '!' or '?'.");
        return false;
    }
    else
        return true;//First character of password does not contain '!' or '?'
    
    }//end firstChar()
/******************************************************************************/
    
    private static void automatedCheck(String[] pwCheck) throws Exception
    {
    int pwType = 0;
     
    // Create a File class object linked to the name of the file to read
    File readFile = new File("passwords.txt");

    // Create a Scanner named "file" to read the input stream from the txt file
    Scanner file = new Scanner(readFile);

    /* The while loop reads lines of text into pwCheck[] with a Scanner class
    *
    * Theboolean function hasNextLine() is used to see if there another line in
    * passwords.txt
    */
    while ( file.hasNextLine() ) 
    {
    // read a line in an array element
    pwCheck[pwType] = file.nextLine(); 
    
    //Prints the read password
    System.out.println("Password Validation " + (pwType + 1) + ": " +
            pwCheck[pwType] );
    
    boolean valLength;
    boolean valNum;
    boolean valUpperC;
    boolean valSpace;
    boolean valFirstChar;
    
    /*
    *Calls the password validation methods to check the read passwords
    */
    valLength = pwLength(pwCheck[pwType]); 
    valNum = numCheck(pwCheck[pwType]);
    valUpperC = upperCCheck(pwCheck[pwType]);
    valSpace = spaceCheck(pwCheck[pwType]);
    valFirstChar = firstChar(pwCheck[pwType]);
    
    //if statement used to state that a read password is valid.
    if ((valLength == true) && (valNum == true) && (valUpperC == true) 
                && (valSpace == true) && (valFirstChar == true))
        System.out.println("-The password is valid.");
        System.out.println("");
    
    pwType ++;
    } // end while
     
    file.close();

    }//end automatedCheck()
    
}// end PwCheck Class
