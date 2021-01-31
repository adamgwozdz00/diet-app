package dietApp.dietapp.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class EmailAlreadyUsedException extends ApplicationRequestException{

    private HttpStatus status = HttpStatus.CONFLICT;

    public EmailAlreadyUsedException(String email) {
        super("Email: " + email + " is already in used!");
    }
}
