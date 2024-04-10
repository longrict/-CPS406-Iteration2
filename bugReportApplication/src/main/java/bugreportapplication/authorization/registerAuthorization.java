/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bugreportapplication.authorization;

/**
 *
 * @author vito
 */
public class registerAuthorization {
    // Checks if the email given is already associated with another user
    public static boolean checkEmailExistence(String email){
        return true;
    }
    
    //OPTIONAL --> Checks if email is of the form user@emailservice.xxx
    public static boolean checkEmailCorrectness(String email){
        return true;
    }
    
    // Checks if the password is the correct length (8), has a capital letter
    public static boolean checkPassword(char[] password){
        return true;
    }
    
    // Verifies password and verifypassword are the same
    public static boolean checkVerify(char[] password){
        return true;
    }
    
    
    // Checks if username is already associated with an existing user
    public static boolean checkUserExistence(String user){
        return true;
    }
    
    // Checks if a username is the correct length 6 characters and is alphanumeric
    public static boolean checkUserCorrectness(String user){
        return true;
    }
    
}
