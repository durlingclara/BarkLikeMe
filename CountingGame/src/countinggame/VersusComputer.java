/*******************************************************************************
 * VersusComputer.java
 * Clara Durling
 * 
 * This class runs the game for a single human playing against the computer.
 ******************************************************************************/

package countinggame;

import java.util.Scanner;

public class VersusComputer {
    
    private static final Scanner SCAN = new Scanner(System.in);
    
    //**************************************************************************
    
    protected static void whoFirst(){
        // Make the game more personal and interactive by using name provided
        System.out.println("What is your name?");
        String playerName = SCAN.next();
        
        // In case name input is blank:
        if(playerName.trim().equals(""))
            playerName = "Player 1";
        
        System.out.println("Would you like to go first? (Yes or No)");
        String crucialChoice = SCAN.next();
        
        System.out.println("");
        System.out.println("Please be sure to type only integers for your choices.");
        System.out.println("");
        
        if(crucialChoice.trim().toLowerCase().equals("yes"))
            
            // Sends the class to the method for the player going first
            VersusComputer.playerFirst(playerName.trim());
        else if(crucialChoice.trim().toLowerCase().equals("no"))
            
            // Sends the class to the method where the computer goes first
            VersusComputer.computerFirst(playerName.trim());
           
    } // End method whoFirst
    
    //**************************************************************************
    
    private static void playerFirst(String name){
    /* If the player chooses to go first, they will loose. 
     * This won't be the case for the 2 player game, as either player may 
     * or may not know the trick to winning*/
        
        // Starting values:
        int lastTurn;
        boolean validTurn = true; 
        
        // Main loop:
        for(lastTurn = 0; lastTurn < 20 && validTurn;){
            System.out.println("I choose " + lastTurn + ".");
            System.out.println("Your turn, " + name + ":");
            int turn = SCAN.nextInt();
            validTurn = Rules.validate(lastTurn, turn); // Makes sure their choice is valid
            lastTurn += 3;
        }
        
        // Determine reason for exiting the loop and the consequence of it.
        if(!validTurn)
            System.out.println("Sorry, you broke the rules. Try again next time.");
        else{
            System.out.println("I choose " + lastTurn + ".");
            System.out.println("Sorry, " + name + ", you loose. Better luck next time!");
        }
           
    } // end method playerFirst
    
    //**************************************************************************
    
    private static void computerFirst(String name){
        // Starting values:
        boolean messedUp = false; 
        boolean validTurn = true;
        int computerTurn;
        int playerTurn = 0;
        
        // Main loop:
        for(computerTurn = 1; computerTurn != 21 && playerTurn != 21 && validTurn && !messedUp;){
            computerTurn = playerTurn + 1;
            System.out.println("My turn:");
            System.out.println("I choose " + computerTurn);
            System.out.println("Your turn:");
            playerTurn = SCAN.nextInt();
            
            // In order to win, you need your choice to be a multiple of 3 each time.
            messedUp = !((playerTurn%3) == 0);
            validTurn = Rules.validate(computerTurn, playerTurn);
            
        } // End of for loop
        
        // Determine reason for exiting the loop and the consequence of it.
        if(messedUp){ // they messed up and now the computer gets to win
            computerTurn = computerTurn + 2;
            while(computerTurn < 20 && validTurn){
                System.out.println("I choose " + computerTurn);
                System.out.println("Your turn, " + name + ":");
                playerTurn = SCAN.nextInt();
                validTurn = Rules.validate(computerTurn, playerTurn); // Makes sure their choice is valid
                computerTurn += 3;
            } //end of while loop
        } // end of else if(messedUp)
        
        if(!validTurn){ // they broke the rules
            System.out.println("Sorry, you broke the rules. Try again next time.");
            Rules.display();
        }else if(playerTurn == 21){
            System.out.println(name + " wins! Good job!");
        }else if(computerTurn == 21){
            System.out.println("Sorry, " + name + ", you lose. Better luck next time!");
        }
        
    } // End method computerFirst
    
} // End class VersusComputer
