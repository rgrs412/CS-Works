package Assignment;

/**
 * Plays a game of rock, paper, scissors.
 * Utilizes a GameFunctions object.
 *
 * See the CSCI112_A1.pdf document for details.
 * 
 * @author Wuheng Yu
 */
import Assignment.GameFunctions;
import java.util.Scanner;
public class GameDemo {

    /*
     * Main Method. This is where the program begins.
     */
    public static void main(String[] args) {
        String userChoice;                                                              //User input of rock, paper, or scissors
        String validChoice;                                                             //Valid input of rock, paper, or scissors
        String answer;                                                                  //Answer for retrying game
        GameFunctions gameRPS = new GameFunctions();                                    //Create an instance of GameFunctions object
        Scanner input = new Scanner(System.in);                                         //Create an instance of Scanner object

        System.out.println("Rock, Paper, Scissors Game\n");
        System.out.print("Enter your choice (rock, paper, or scissors): ");
        userChoice = input.nextLine();                                                  //User input
        validChoice = choiceCheck(userChoice);                                          //Calls choiceCheck() and assigns its return value to validChoice

        gameRPS.getRPS();                                                               //Get computer's choice for rock, paper, or scissors
        System.out.println(gameRPS.whoWon(validChoice));                                //Prints out the winner of the current RPS round.

        System.out.print("Would you like to play again? (Y for yes): ");
        answer = input.nextLine();
        System.out.println("");

        while(true) {                                                                   //while loop to keep retrying RPS game as long as user wants
            if (answer.equalsIgnoreCase("y")) {                            //If user enters Y or y, RPS game will restart. Otherwise, RPS game will end.
                System.out.print("Enter your choice (rock, paper, or scissors): ");
                userChoice = input.nextLine();
                validChoice = choiceCheck(userChoice);

                gameRPS.getRPS();
                System.out.println(gameRPS.whoWon(validChoice));

                System.out.print("Would you like to play again? (Y for yes): ");
                answer = input.nextLine();
                System.out.println("");
            }
            else {
                break;
            }
        }
    }//end main()

    /**
     *This method checks if the user input is rock, paper, or scissors, regardless of uppercase or lowercase.
     *If user input is invalid, an error message will be displayed to prompt the user to enter a valid input.
     *A while loop is used to continuously display the error message if user continuously enter invalid input.
     *If user input is valid, the program will break out of while loop and returns the valid input.
     */
    public static String choiceCheck(String userInput) {
        Scanner input = new Scanner(System.in);                                           //Creates an instance of a scanner object in this method
        String userChoice;                                                                //Validated user input of rock, paper, or scissors.
        userChoice = userInput.toLowerCase();                                             //Sets the userInput to all lowercase

        while(true) {
            if((userChoice.matches("rock")) || (userChoice.matches("paper")) || (userChoice.matches("scissors"))) {
                break;
            }
            else {
                System.out.println("Invalid choice. Please try again.");
                System.out.print("Enter your choice (rock, paper, or scissors): ");
                userChoice = input.nextLine();
                userChoice.toLowerCase();
            }
        }
        return userChoice;
    }//end choiceCheck()

}//End class GameDemo
