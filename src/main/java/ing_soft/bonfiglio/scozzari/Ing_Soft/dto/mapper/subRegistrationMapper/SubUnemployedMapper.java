package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.subRegistrationMapper;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationDTO.SubTemporaryWorkDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationDTO.SubUnemployedDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.TemporaryWork;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Unemployed;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class SubUnemployedMapper {
    public static Unemployed mapToUnemployed(SubUnemployedDTO subUnemployedDTO) {
        if (subUnemployedDTO == null) {
            return null;
        }

        Unemployed unemployed = new Unemployed();
        unemployed.setAllowance(subUnemployedDTO.getAllowance());

        return unemployed;
    }

}
