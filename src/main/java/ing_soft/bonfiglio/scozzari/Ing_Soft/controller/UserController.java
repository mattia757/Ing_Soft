package ing_soft.bonfiglio.scozzari.Ing_Soft.controller;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.RegistrationArtistDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.RegistrationArtistMapper;
import ing_soft.bonfiglio.scozzari.Ing_Soft.exception.UnauthenticatedUserException;
import ing_soft.bonfiglio.scozzari.Ing_Soft.exception.UserNotFoundException;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.User;
import ing_soft.bonfiglio.scozzari.Ing_Soft.security.auth.AuthenticationService;
import ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    private RegistrationArtistMapper registrationArtistMapper;


    @Autowired
    private AuthenticationService authenticationService;

    @PutMapping(value = "/updatePassword/{id}", consumes = "application/json")
    public ResponseEntity<String> updateUserPassword(
            @PathVariable("id") Long id,
            @RequestBody @Valid String password
    ) throws UserNotFoundException, UnauthenticatedUserException {
        Optional<User> authenticationUser = authenticationService.getAuthenticationUser();
        if(authenticationUser.isPresent()){
            User user = authenticationUser.get();
            if(user.getId().equals(id)){
                userService.updateUserPassword(id, password);
                return ResponseEntity.ok("Password updated successfully");
            }
            else {
                return ResponseEntity.badRequest().body("You are not authorized to change your password");
            }
        }
        else {
            throw new UnauthenticatedUserException("Unauthorized user");
        }
    }
}
