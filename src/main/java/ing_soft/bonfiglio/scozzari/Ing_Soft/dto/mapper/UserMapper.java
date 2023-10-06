package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.UserDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.User;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserMapper {
    public UserDTO userToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setEmail( user.getEmail() );
        userDTO.setPassword( user.getPassword() );
        userDTO.setRole( user.getRole() );

        return userDTO;
    }

    public User userDTOToUser(UserDTO userdto) {
        if ( userdto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.email( userdto.getEmail() );
        user.password( userdto.getPassword() );
        user.role( userdto.getRole() );

        return user.build();
    }
}