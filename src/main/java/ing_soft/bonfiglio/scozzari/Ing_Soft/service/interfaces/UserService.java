package ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces;

import ing_soft.bonfiglio.scozzari.Ing_Soft.exception.UserNotFoundException;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.User;

import java.util.Optional;

public interface UserService {
    void updateUserPassword(Long id, String newPassword) throws UserNotFoundException;
    Optional<User> getUserByUsername(String username);
}
