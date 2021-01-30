package dietApp.dietapp.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserAlreadyExistException extends ApplicationRequestException{

    private HttpStatus status = HttpStatus.CONFLICT;

    public UserAlreadyExistException(String username) {
       super("User with username: " + username +" already exist!");
    }
}
