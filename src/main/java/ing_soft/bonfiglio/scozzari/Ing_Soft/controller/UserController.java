package ing_soft.bonfiglio.scozzari.Ing_Soft.controller;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.User;
import ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/insert", consumes = "application/json")
    public ResponseEntity<String> insert(@RequestBody @Valid User user){
        Optional<Boolean> result = userService.insert(user);
        if(result.orElse(false)){
            return new ResponseEntity<>("Utente inserito correttamente", HttpStatus.CREATED);
        } else{
            return new ResponseEntity<>("ERRORE", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "/delete/{id}", consumes = "application/json")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        Optional<Boolean> result = userService.delete(id);
        if(result.orElse(false)){
            return new ResponseEntity<>("Utente rimosso correttamente", HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>("Impossibile rimuovere l'utente , esso non è presente nel Database", HttpStatus.BAD_REQUEST);
        }
    }

    /*
    @PutMapping(path = "update/{id}" , consumes = "application/json")
    public ResponseEntity<String> update(@PathVariable("id") Long id , @RequestParam("email") @Valid String email){
        if(userService.update(id ,email)){
            return new ResponseEntity<>("Email modificata correttamente", HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>("ERRORE, Impossibile modificare l'email", HttpStatus.BAD_REQUEST);
        }
    }
    */

}
