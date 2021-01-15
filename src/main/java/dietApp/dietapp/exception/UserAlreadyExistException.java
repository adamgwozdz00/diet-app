package dietApp.dietapp.exception;


public class UserAlreadyExistException extends RuntimeException{

    public UserAlreadyExistException(String username) {
       super("User with username: " + username +" already exist!");
    }
}
