package ing_soft.bonfiglio.scozzari.Ing_Soft.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception{

    public UserNotFoundException(Long id) {
        super("User not found with ID: " + id);
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
