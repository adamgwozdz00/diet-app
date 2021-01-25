package dietApp.dietapp.user.exception;

public class UserPasswordsNotSameException extends IllegalArgumentException {

    public UserPasswordsNotSameException() {
        super("Passwords are not the same!");
    }
}