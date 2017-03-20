/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whiggly;

/**
 *
 * @author Clara Durling
 */
public class User {
    private final String firstName;
    private final String lastName;
    private final String username;
    private char[] password;
    private Boolean nightQuiet;
    private Boolean morningQuiet;
    private Boolean keepsClean;
    private Boolean cleanRoomMate;
    
    public User(String firstName, String lastName, String username, char[] password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }
    
    public void changePassword(char[] newPassword){
        this.password = newPassword;
    }
    
    /**
     *
     * @return password
     */
    public char[] getPassword(){
        return this.password;
    }
    
    /**
     *
     * @param nightQuiet
     * @param morningQuiet
     * @param keepsClean
     * @param cleanRoomMate
     */
    public void setPreferences(boolean nightQuiet, boolean morningQuiet, boolean keepsClean, boolean cleanRoomMate){
        this.nightQuiet = nightQuiet;
        this.morningQuiet = morningQuiet;
        this.keepsClean = keepsClean;
        this.cleanRoomMate = cleanRoomMate;
    }
    
    /**
     *
     * @return boolean
     */
    public Boolean getNightPref(){
        return this.nightQuiet;
    }
    
    /**
     *
     * @return boolean
     */
    public Boolean getMorningPref(){
        return this.morningQuiet;
    }
    
    /**
     *
     * @return boolean
     */
    public Boolean getCleanliness(){
        return this.keepsClean;
    }
    
    /**
     *
     * @return boolean
     */
    public Boolean getCleanRoomMatePref(){
        return this.cleanRoomMate;
    }
    
    /**
     *
     * @param user2
     * @return boolean
     */
    public Boolean checkForMatch(User user2){
        boolean match = false;
        //figure out matching requirements
        return match;
    }

    @Override
    public String toString() {
        return "Username: " + this.username + ", " + this.firstName + " " + this.lastName;
    }
       
}
