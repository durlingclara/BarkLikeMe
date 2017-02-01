/*******************************************************************************
 * CountingGame.java
 * Clara Durling
 * 
 * This class runs the program for the game, Count to 21.
 ******************************************************************************/
package countinggame;

import java.util.Scanner;

public class CountingGame {

    public static void play() {
        Scanner scan = new Scanner(System.in); // Creates scanner
        
        // Possible display of the rules of the game
        System.out.println("Would you like to view the rules(Yes or No)?");
        String rules = scan.next();
        
        if(rules.trim().toLowerCase().equals("yes")) // Displays the rules for the player(s)
            Rules.display();
        
        
        // Determine whether the game will be played against the computer or another human
        System.out.println("");
        System.out.println("Would you like to play against: 1) the computer, or 2) another human?");
        System.out.println("(Please enter the number for your choice.)");
        boolean validOption;
        
        do{
            int gameType = scan.nextInt();
            switch(gameType){
                case 1:
                    VersusComputer.whoFirst(); // Runs the game against the computer
                    validOption = true;
                    break;
                case 2:
                    TwoPlayer.game(); // Runs the game for two players
                    validOption = true;
                    break;
                default:
                    System.out.println("Please make sure that you are entering either 1 or 2, in numeral form.");
                    System.out.println("If you enter 1, you will play against the computer.");
                    System.out.println("If you enter 2, you will play against another human.");
                    validOption = false;
                    break; 
            } // End switch
        }while(!validOption); // End of do loop     
        
    } // End method play
    
} // End class CountingGame
