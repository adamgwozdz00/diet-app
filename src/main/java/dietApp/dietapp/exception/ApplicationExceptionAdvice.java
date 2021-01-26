package dietApp.dietapp.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ApplicationExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(value = {UserAlreadyExistException.class,UserPasswordsNotSameException.class, UsernameNotFoundException.class})
    public ResponseEntity<Object> ApplicationExceptionHandler(ApplicationRequestException e){
            ApplicationException applicationException = new ApplicationException(
                    e.getStatus(),
                    e.getMessage()
            );

            return new ResponseEntity<>(applicationException,e.getStatus());
    }

}
