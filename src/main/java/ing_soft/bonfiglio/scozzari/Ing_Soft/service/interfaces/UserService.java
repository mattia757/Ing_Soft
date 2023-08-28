package ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.UserDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.exception.UserNotFoundException;

import java.util.Optional;

public interface UserService {

    Optional<UserDTO> getUserById(Long idUserNotFound) throws UserNotFoundException;

    Optional<UserDTO> getUserByUsername(String EmailUserNotFound) throws UserNotFoundException;
}
