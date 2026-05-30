package util;

import org.mindrot.jbcrypt.BCrypt;

public class JBcrypt {
    BCrypt bcrypt = new BCrypt();

    public String hashPassword(String password){
        String hashedPassword =  bcrypt.hashpw(password, BCrypt.gensalt());
        return hashedPassword;
    }

    public boolean comparePassword (String userInputPass, String dbPassword){
        boolean isCorrect = bcrypt.checkpw(userInputPass, dbPassword);
        return isCorrect;
    }

}
