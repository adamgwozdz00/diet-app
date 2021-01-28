package dietApp.dietapp.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class FoodNotExistException extends ApplicationRequestException{

    private HttpStatus status = HttpStatus.BAD_REQUEST;

    public FoodNotExistException(String foodName) {
        super(foodName + " not exist");
    }
}
