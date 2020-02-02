package Assignment;

/**
 * GameFunctions Object.
 * See the CSCI112_A1.pdf document for details.
 * 
 * @author Wuheng Yu
 *
 * This class is used to create game functions of the game, Rock, Paper, Scissors.
 */
import java.util.Random;
public class GameFunctions {
    
    private Random rGen;                                                   //Random object for generating random numbers
    private String cpuChoice;                                              //Computer choice, which can be RPS(rock, paper, or scissors)

    /**
     * Constructor
     */
    public GameFunctions() {
        rGen = new Random();                                               //Instantiates random object rGen
        cpuChoice = "";                                                    //Sets empty String for cpuChoice
    }

    /**
     * Generates a random number that's associated with rock, paper, or scissors.
     * cpuChoice will be assigned rock, paper , or scissors, based on the generated random number.
     * Prints out cpuChoice.
     */
    public void getRPS() {
        int rNum;                                                           //Declare random number variable
        rNum = rGen.nextInt(3) + 1;                                 //Assign rNum a random number from 1 to 3

        if(rNum == 1) {
            cpuChoice = "rock";
        }
        else if(rNum == 2) {
            cpuChoice = "paper";
        }
        else if(rNum == 3) {
            cpuChoice = "scissors";
        }

        System.out.println("The computer chose: " + cpuChoice);
    }

    /**
     *Sets all the winning conditions for RPS.
     * Use a.matches(b) to check that cpuChoice and userChoice match rock, paper, or scissors.
     * If cpuChoice and userChoice have the same string, the result is a tie.
     */
    public String whoWon(String userChoice) {
        if ((cpuChoice.matches("rock")) && (userChoice.matches("paper"))) {
            return "Winner: user";
        }
        else if((cpuChoice.matches("rock")) && (userChoice.matches("scissors"))) {
            return "Winner: computer";
        }
        else if((cpuChoice.matches("paper")) && (userChoice.matches("rock"))) {
            return "Winner: computer";
        }
        else if((cpuChoice.matches("paper")) && (userChoice.matches("scissors"))) {
            return "Winner: user";
        }
        else if((cpuChoice.matches("scissors")) && (userChoice.matches("rock"))) {
            return "Winner: user";
        }
        else if((cpuChoice.matches("scissors")) && (userChoice.matches("paper"))) {
            return "Winner: computer";
        }
        else {
            return "Tie";
        }
    }
    
}
