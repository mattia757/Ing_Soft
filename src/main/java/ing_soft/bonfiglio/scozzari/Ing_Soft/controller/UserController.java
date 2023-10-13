package ing_soft.bonfiglio.scozzari.Ing_Soft.controller;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.RegistrationArtistMapper;
import ing_soft.bonfiglio.scozzari.Ing_Soft.exception.UnauthenticatedUserException;
import ing_soft.bonfiglio.scozzari.Ing_Soft.exception.UserNotFoundException;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.User;
import ing_soft.bonfiglio.scozzari.Ing_Soft.security.auth.AuthenticationService;
import ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces.UserService;
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
    private RegistrationArtistMapper registrationArtistMapper;
    @Autowired
    private AuthenticationService authenticationService;

    @PutMapping("/updatePassword")
    public ResponseEntity<String> updateUserPassword(
            @RequestParam Long id,
            @RequestParam String newPassword
    ) {
        try {
            Optional<User> authenticatedUser = authenticationService.getAuthenticationUser();

            if (authenticatedUser.isEmpty()) {
                throw new UnauthenticatedUserException("Unauthenticated user");
            }

            User user = authenticatedUser.get();

            if (!user.getId().equals(id)) {
                throw new UserNotFoundException("User not found!");
            }
            userService.updateUserPassword(id, newPassword);
            return ResponseEntity.ok("Password aggiornata con successo");
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Utente non trovato");
        } catch (UnauthenticatedUserException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Utente non autenticato");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore durante l'aggiornamento della password");
        }
    }

}
