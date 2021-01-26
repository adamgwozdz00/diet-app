package dietApp.dietapp.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserPasswordsNotSameException extends ApplicationRequestException {

    private HttpStatus status = HttpStatus.CONFLICT;

    public UserPasswordsNotSameException() {
        super("Passwords are not the same!");
    }

}
