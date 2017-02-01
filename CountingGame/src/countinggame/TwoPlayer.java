/*******************************************************************************
 * VersusComputer.java
 * Clara Durling
 * 
 * This class runs the game for a human playing against another human.
 ******************************************************************************/
package countinggame;

import java.util.Scanner;

public class TwoPlayer {
    
    public static void game(){
        Scanner SCAN = new Scanner(System.in);
        
        // Make the game more personal and interactive by using names provided by each player
        System.out.println("What is player 1's name?");
        String name1 = SCAN.next();
        System.out.println("What is player 2's name?");
        String name2 = SCAN.next();
        
        // In case name input is blank:
        if(name1.trim().equals(""))
            name1 = "Player 1";
        if(name2.trim().equals(""))
            name2 = "Player 2";
        
        // Starting values:
        int player1;
        int player2 = 0;
        boolean validTurn1 = true;
        boolean validTurn2 = true;
        
        System.out.println("");
        System.out.println("Please be sure to type only integers for your choices.");
        System.out.println("");
        
        // Main loop:
        for(player1 = 0; player1 != 21 && player2 != 21 && validTurn1 && validTurn2;){
            System.out.println(name1.trim() + ":");
            player1 = SCAN.nextInt();
            validTurn1 = Rules.validate(player2, player1);
            if(player1 != 21 && validTurn1){
                System.out.println(name2.trim() + ":");
                player2 = SCAN.nextInt();
                validTurn2 = Rules.validate(player1, player2);
            }
            
        } // End for loop
        
        // Determine reason for exiting the loop and the consequence of it.
        if(!validTurn1){
            System.out.println(name1.trim() + " broke the rules.");
            Rules.display();
        }else if(!validTurn2){
            System.out.println(name2.trim() + " broke the rules.");
            Rules.display();
        }else if(player1 == 21){
            System.out.println("Player 1 wins!");
        }else if(player2 == 21){
            System.out.println("Player 2 wins!");
        }
        
    } // End method game
    
} // End TwoPlayer class
