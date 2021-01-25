package dietApp.dietapp.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserPasswordsNotSameAdvice {

    @ResponseBody
    @ExceptionHandler(UserPasswordsNotSameException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String  UserPasswordsNotSameHandler(UserPasswordsNotSameException e){
        return e.getMessage();
    }
}
