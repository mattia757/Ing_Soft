package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.subRegistrationMapper;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationDTO.SubRetiredDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Retired;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class SubRetiredMapper {

    public static Retired mapToRetired(SubRetiredDTO subRetiredDTO) {
        if (subRetiredDTO == null) {
            return null;
        }

        Retired retired = new Retired();
        retired.setOver65(subRetiredDTO.isOver65());

        return retired;
    }
}
