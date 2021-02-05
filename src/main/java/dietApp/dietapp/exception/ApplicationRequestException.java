package dietApp.dietapp.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class ApplicationRequestException extends Exception{

    private HttpStatus status;

    public ApplicationRequestException(String message) {
        super(message);
    }

}
