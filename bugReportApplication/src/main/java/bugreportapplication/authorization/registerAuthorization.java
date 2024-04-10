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
    
    //OPTIONAL --> Checks if email is of the form user@emailservice.xxx
    public static boolean checkEmailCorrectness(String email){
        return true;
    }
    
    // Checks if the password is the correct length (8) or larger, has a capital letter
    public static boolean checkPassword(char[] password){
        int passSize = password.length;
        boolean correct = false;
        if (passSize >= 8){
            for (int i = 0; i < passSize; i++){
                if (Character.isUpperCase(password[i])){
                    correct = true;
                }
                // For security
                password[i] = 0;
            }
        }
        return correct;
    }
    
    
    // Verifies password and verifypassword are the same
    public static boolean checkVerify(char[] password, char[] verify){
        int passLen = password.length;
        if (passLen == verify.length){
            for (int i = 0; i < passLen; i++){
                if (password[i] != verify[i]){
                    return false;
                }
            }
        }else {
            return false;
        }
        
        return true;
    }
    
    // Checks if a username is the correct length 6 characters and is alphanumeric
    public static boolean checkUserCorrectness(String user){
        if (user.length() >= 6){
            for (int i = 0; i < user.length(); i++){
                if (!(Character.isAlphabetic(user.charAt(i)) || Character.isDigit(user.charAt(i)))){
                    return false;
                }
            }
        } else {
            return false;
        } 
        return true;
    }
    
}
