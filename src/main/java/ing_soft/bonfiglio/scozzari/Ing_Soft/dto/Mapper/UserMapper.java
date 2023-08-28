package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.Mapper;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.UserDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.User;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserMapper implements Function<User, UserDTO> {
    @Override
    public UserDTO apply(User user) {
        return new UserDTO(
                user.getUsername(),
                user.getPassword()
        );
    }

    public User apply(UserDTO userDTO){
        return new User(
                userDTO.getUsername(),
                userDTO.getPassword()
        );
    }
}
