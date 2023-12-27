/**
 *
 * @author Jacob Jones
 * @date 1/30/20
 * This program pits the player against the computer in a game of Rock-Paper-Scissors
 */

package jjonesrps;

import Utilities.InputVerification;
import java.util.Random;
import javax.swing.JOptionPane;

public class JJonesRPS extends InputVerification {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // The Variables
        Random rand = new Random(); // Helps generate random numbers
        
        int playerChoice; // The player's choice
        int compChoice; // The computer's choice
        // 1 is Rock, 2 is Paper, and 3 is Scissors
        
        int playerWins = 0; // How many times the player has won
        int compWins = 0; // How many times the computer has won
        int ties = 0; // How many ties there have been
        int winner; // The current winner of the round
        // -1 is unknown, 0 is a tie, 1 is the player, and 2 is the computer
        
        String ifContinue; // If the player wants to play again
        
        // The introduction message
        String startMessage = "In this program, you and the computer will play a game of Rock Paper Scissors.";
        startMessage += "\nRemember,\nRock smashes Scissors,\nScissors cuts Paper,\nand Paper covers Rock.";
        String finalMessage; // The results message
        
        // The Main Loop
        do{
            
            // Sets up the final message
            finalMessage = "The results are in!\n\nThis game's winner is...";
            
            // Sets winner to the default value of -1
            winner = -1;
            
            // Displays the introductary message
            JOptionPane.showMessageDialog(null, startMessage);
            
            // Loops until a winner is decided
            do{
                // Generates the computer's choice
                compChoice = rand.nextInt(2) + 1;
                System.out.println("Computer: " + compChoice);
                
                // Obtains the player's choice
                playerChoice = intInput("Now, pick a number between 1 and 3, with 1 being Rock, 2 being Paper, and 3 being Scissors", 1, 3);
                System.out.println("Player: " + playerChoice);
                
                // Determines the winner
                winner = checkGame(playerChoice, compChoice);
                System.out.println("Winner: " + winner);
            } while (!intInBounds(winner, 0, 2));
            
            // Depending on who the winner is, it adds a different message
            switch(winner){
                // When the player is the winner
                case 1:
                    finalMessage += "\nThe player! Good job!";
                    playerWins++;
                    break;
                // When the computer is the winner
                case 2:
                    finalMessage += "\nThe computer! Better luck next time!";
                    compWins++;
                    break;
                // When there is no winner
                default:
                    finalMessage += "\nNo one! It's a tie!";
                    ties++;
                    break;
            }
            
            // Shows the current win tally
            finalMessage += "\n\nPlayer Wins: " + playerWins + "\nComputer wins: " + compWins + "\nTies: " + ties;
            
            // Displays the results
            JOptionPane.showMessageDialog(null, finalMessage);
            
            // Obtains whether or not the player wants to continue
            ifContinue = stringChoiceInput("Would you like to play again (Y/N)?", "Y", "N");
        } while(ifContinue.equals("Y"));
        
        // Displays a goodbye message
        JOptionPane.showMessageDialog(null, "Thank you for playing the game!");
    }
    
    /**
     * This method compares the player's move to the computer's move,
     * and determines the winner based on the result
     * 
     * @param player - The player's move
     * @param comp - The computer's move
     * @return winner - The winner
     */
    public static int checkGame(int player, int comp){
        
        // The values of each choice
        final int ROCK = 1;
        final int PAPER = 2;
        final int SCISSORS = 3;
        
        // Whoever the winner is
        int winner;
        
        // Depending on the player's move, it will check what the computer picked,
        // and determines the result
        switch (player) {
            case ROCK:
                switch (comp) {
                    case SCISSORS:
                        winner = 1;
                        break;
                    case PAPER:
                        winner = 2;
                        break;
                    default:
                        winner = 0;
                        break;
                }   
                break;
            case PAPER:
                switch (comp) {
                    case ROCK:
                        winner = 1;
                        break;
                    case SCISSORS:
                        winner = 2;
                        break;
                    default:
                        winner = 0;
                        break;
                }   
                break;
            case SCISSORS:
                switch (comp) {
                    case PAPER:
                        winner = 1;
                        break;
                    case ROCK:
                        winner = 2;
                        break;
                    default:
                        winner = 0;
                        break;
                }   
                break;
            // If the player made any other move, that means they somehow entered
            // an invalid input
            default:
                System.out.print("Invalid input, try again!");
                winner = -1;
                break;
        }
        
        // Returns the winner
        return winner;
    }
}
