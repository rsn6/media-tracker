package util;

import edu.csueb.mediatracker.bean.User;
import java.util.List;


public class UserUtil {
    public static String current;
    public static User authUser(String email, String password){
        current = email;
        User user = null;
        List<User> users = DBUtil.getUsers();
        
        for(User u : users){
            if(u.getEmail().equals(email) && u.getPassword().equals(password)){
                user = u;
                break;
            }
        }
        return user;
    }
    public static String validateUser(User user){
        String msg = "";
        if(user.getEmail() == null | user.getEmail().equals("") ||
            user.getLastname() == null | user.getLastname().equals("") ||
            user.getFirstname() == null | user.getFirstname().equals("") ||
            user.getPassword() == null | user.getPassword().equals("")){
            
            msg += "Please fill in all blanks\n";
            
        }
        
        List<User> users = DBUtil.getUsers();
        for(User u : users){
            if(u.getEmail().equals(user.getEmail())){
                msg += "Email is already used. Please choose another email\n";
            }
        }
        
        return msg;
    }
    
    public static void addUser(User u){
        DBUtil.createUser(u);
    }
}
