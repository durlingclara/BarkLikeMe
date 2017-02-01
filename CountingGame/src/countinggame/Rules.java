/*******************************************************************************
 * Rules.java
 * Clara Durling
 * 
 * This class displays the rules and makes sure the rules are being followed;
 ******************************************************************************/
package countinggame;


public class Rules {
    
    // Displays the rules of the game if the player asks for them
    protected static void display(){
        System.out.println("");
        System.out.println("These are the rules of the game:");
        System.out.println("Whoever goes first can choose either the number one or two.");
        System.out.println("After that, each player must choose a number either "
                + "one or two higher than the last number chosen.");
        System.out.println("Whichever player reaches 21, wins.");
    }
    
    //**************************************************************************
    
    // Makes sure that the player is following the rules of counting
    protected static boolean validate(int lastTurn, int thisTurn){
        
        boolean valid;
        int difference = thisTurn - lastTurn;
        valid = !(difference == 0 || difference > 2);
        return valid;
        
    } // End validate
    
} // End class
