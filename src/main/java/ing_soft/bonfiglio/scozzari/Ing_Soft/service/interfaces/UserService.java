package ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.UserDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.User;

import java.util.Optional;

public interface UserService {

    Optional<UserDTO> findByEmail(String email);
    Optional<Boolean> insert(User user);
    Optional<Boolean> delete(String email);

}
