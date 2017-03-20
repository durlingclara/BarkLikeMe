/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whiggly;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author durlicla000
 */
public class MemberData {
    public static Map member = new HashMap();
    public static Set<String> usernames = member.keySet();
   
    public static void addMember(User newUser, String username){
        member.put(username, newUser);
    }
    
    public static Boolean usernameAvailability(String requestedUsername){
        boolean available = !usernames.contains(requestedUsername);
        return available;
    }
    
    public static Boolean isPasswordCorrect(String username, char[] password){
        boolean correctPassword = false;
        User currentUser = (User) member.get(username);
        System.out.println(currentUser);
        return correctPassword;
    }
}
