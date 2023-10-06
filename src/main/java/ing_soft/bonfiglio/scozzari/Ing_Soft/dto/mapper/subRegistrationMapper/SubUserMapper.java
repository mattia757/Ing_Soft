package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.subRegistrationMapper;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationDTO.SubUserDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class SubUserMapper {

    public static User userDTOToUser(SubUserDTO subUserDTO) {
        if (subUserDTO == null) {
            return null;
        }

        User user = new User();
        user.setName(subUserDTO.getName());
        user.setSurname(subUserDTO.getSurname());
        user.setEmail(subUserDTO.getEmail()); // Email Referent
        user.setTaxCode(subUserDTO.getTaxCode());

        return user;
    }

    public static SubUserDTO userToSubUserDTO(User user) {
        if (user == null) {
            return null;
        }

        SubUserDTO subUserDTO = new SubUserDTO();
        subUserDTO.setName(user.getName());
        subUserDTO.setSurname(user.getSurname());
        subUserDTO.setEmail(user.getEmail()); // Email Referent
        subUserDTO.setTaxCode(user.getTaxCode());

        return subUserDTO;
    }
}