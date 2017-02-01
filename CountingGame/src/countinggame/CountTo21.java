/******************************************************************************* 
 * CountTo21.java
 * 
 * Clara Durling
 * This class runs the code for the game in a do loop.  The loop reiterates as 
 * long as the user wants to play again.
 ******************************************************************************/
package countinggame;

import java.util.Scanner;

/**
 *
 * @author durlicla000
 */
public class CountTo21 {
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Count to 21 game!"); // Introduction message
        
        boolean playAgain;
        do{
            CountingGame newGame = new CountingGame();
            newGame.play(); // runs the game
            
            System.out.println("Would you like to play again? (Yes or No)");
            String answer = scan.next();
            switch(answer.toLowerCase().trim()){
                case "yes":
                    playAgain = true;
                    break;
                case "no":
                    playAgain = false;
                    break;
                default:
                    playAgain = false;
                    break;
            }
        }while(playAgain);
        
        System.out.println("");
        System.out.println("Thank you for playing Count to 21!"); // Goodbye message
    }
}
