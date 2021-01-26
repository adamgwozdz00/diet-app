package dietApp.dietapp.exception;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;


@RequiredArgsConstructor
@Getter
public class ApplicationException{

    private final HttpStatus httpStatus;
    private final String message;

}
