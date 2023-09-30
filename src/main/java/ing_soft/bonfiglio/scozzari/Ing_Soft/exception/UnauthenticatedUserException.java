package ing_soft.bonfiglio.scozzari.Ing_Soft.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthenticatedUserException extends Exception{

    public UnauthenticatedUserException(Long id){
        super("The user is not authorized to perform this action");
    }

    public UnauthenticatedUserException(String message){
        super(message);
    }

}
