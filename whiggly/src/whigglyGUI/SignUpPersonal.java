/*******************************************************************************
 * signUpPersonal.java
 * Clara Durling
 * 
 * This class holds the first GUI frame for signing up for an account
 ******************************************************************************/
package whigglyGUI;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.text.MaskFormatter;
import whiggly.User;
import whiggly.MemberData;

/**
 *
 * @author Clara Durling
 */
public class SignUpPersonal{
    
    public static void load(){
        
        JFrame getUserInfo = new JFrame("Personal Information");
        getUserInfo.setBounds(0, 0, 400, 300);
        getUserInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // First name field
        JLabel fnameLabel = new JLabel("First Name:");
        fnameLabel.setBounds(5, 10, 70, 20);
        
        JFormattedTextField fnameField;
        fnameField = new JFormattedTextField(createFormatter("????"));
        fnameField.setBounds(80, 10, 100, 20);
        String firstName = (String)fnameField.getValue();
        
        // Last name field
        JLabel lNameLabel = new JLabel("Last Name:");
        lNameLabel.setBounds(5, 35, 70, 20);
        
        JFormattedTextField lNameField;
        lNameField = new JFormattedTextField(createFormatter("????"));
        lNameField.setBounds(80, 35, 100, 20);
        String lastName = (String)lNameField.getValue();
        
        /*
         * MAJOR TODO:
         * username label will  not appear, and moves down the lNameLabel
         * troubleshoot for the problem causer
         */
        
        // Pick a username field
        JLabel usernameLabel = new JLabel("Username:");
        lNameLabel.setBounds(5, 60, 70, 20);
        
        JFormattedTextField usernameField = new JFormattedTextField();
        usernameField.setBounds(80, 60, 100, 20);
        
         //Choose a password field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(5, 85, 70, 20);
        
        JPasswordField passwordField = new JPasswordField(10);
        passwordField.setBounds(80, 85, 100, 20);
        
         //TODO: Validate password, add password requirements
         //TODO: Password requirements: 10+ characters, 1+ numbers, 1+ spec. character
        
        // Confirm password field
        JLabel passwordConfirmLabel = new JLabel("Confirm password:");
        passwordConfirmLabel.setBounds(5, 110, 70, 20);
        
        JPasswordField passwordConfirmField = new JPasswordField();
        passwordConfirmField.setBounds(80, 110, 100, 20);
        
        // Submit button
        JButton submit = new JButton("Sign Up");
        submit.setBounds(5, 135, 100, 30);
        submit.setMnemonic(KeyEvent.VK_S);
        
        submit.addActionListener((ActionEvent e) -> {
            String username = (String)usernameField.getValue();
            boolean usernameAvailable;
            usernameAvailable = MemberData.usernameAvailability(username);
            char[] password = passwordField.getPassword();
            char[] passwordConfirm = passwordConfirmField.getPassword();
            boolean passwordsSame;
            passwordsSame = arePasswordsTheSame(password, passwordConfirm);
            if(passwordsSame && usernameAvailable){
                User newUser = new User(firstName, lastName, username, password);
                MemberData.addMember(newUser, username);
                System.out.println(newUser);
                SetPreferencesSignUp.load(newUser);
                getUserInfo.dispose();
            }else{
                if(!passwordsSame){
                    JOptionPane.showMessageDialog(getUserInfo,
                    "Passwords do not match.",
                    "Error Message",
                    JOptionPane.ERROR_MESSAGE);
                }
                if(!usernameAvailable){
                    JOptionPane.showMessageDialog(getUserInfo,
                    "Username not available",
                    "Error Message",
                    JOptionPane.ERROR_MESSAGE);
                }
            }
                
            
        });
        
        /* TODO:
         * Decide on other personal information that is relevant
         * Create labels and input boxes for this information
         * Either modify User constructor to include any new final info,
         *      or add a new method in User class to set any non-final info
         */
        
        getUserInfo.add(fnameLabel);
        getUserInfo.add(fnameField);
        getUserInfo.add(lNameLabel);
        getUserInfo.add(lNameField);
        getUserInfo.add(usernameLabel);
        getUserInfo.add(usernameField);
        getUserInfo.add(passwordLabel);
        getUserInfo.add(passwordField);
        getUserInfo.add(passwordConfirmLabel);
        getUserInfo.add(passwordConfirmField);
        getUserInfo.add(submit);
       
        getUserInfo.setLayout(null);
        getUserInfo.setVisible(true);
    }
    
    protected static MaskFormatter createFormatter(String s) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(s);
        } catch (java.text.ParseException exc) {
            System.err.println("formatter is bad: " + exc.getMessage());
            System.exit(-1);
        }
        return formatter;
    }
    
    private static Boolean arePasswordsTheSame(char[] password, char[] passwordConfirm){
        boolean same = true;
        if(password.length != passwordConfirm.length){
            same = false;
        }else{
            for(int i = 0; i < password.length;){
                char passChar = password[i];
                char passConfChar = passwordConfirm[i];
                if(passChar !=passConfChar){
                    same = false;
                    i = password.length;
                }else{
                    i++;
                }
            }
        }
        return same;
    }
    
    private static void isValidPassword(char[] password){
        
    }
   
}
