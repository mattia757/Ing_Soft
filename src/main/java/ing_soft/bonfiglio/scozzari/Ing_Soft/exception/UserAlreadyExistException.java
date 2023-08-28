package ing_soft.bonfiglio.scozzari.Ing_Soft.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class UserAlreadyExistException extends Exception{

    public UserAlreadyExistException(Long id) {
        super("User already found with ID: " + id);
    }

    public UserAlreadyExistException(String message) {
        super(message);
    }
}
