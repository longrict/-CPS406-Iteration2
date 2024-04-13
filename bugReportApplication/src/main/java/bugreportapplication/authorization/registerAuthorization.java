package bugreportapplication.authorization;

/**
 *
 * @author David Liu, Longric Tran, Refath Ahmed, Tao Wang, Vito Carnovale (Group #33)
 *
 * Represents a registerAuthorization class to check for valid credentials
 */
public class registerAuthorization {
    
    
    // Checks if the password is the correct length (8) or larger, has a capital letter
    public static boolean checkPassword(char[] password){
        int passSize = password.length;
        boolean correct = false;
        if (passSize >= 8){ // Make sure the pass is at least 8 long
            
            // Loop through pass and make sure theres at least one capital letter
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
        
        // Makes sure length of password is same as length of verify password
        if (passLen == verify.length){
            
            // Checks if each character in password and verifypassword are the same
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
        
        // Ensure the length of the username is greater than 6
        if (user.length() >= 6){
            
            // Loop through the string and ensure its alphanumeric
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
