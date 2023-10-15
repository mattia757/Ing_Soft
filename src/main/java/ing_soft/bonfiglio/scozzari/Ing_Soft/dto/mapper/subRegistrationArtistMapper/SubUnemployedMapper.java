package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.subRegistrationArtistMapper;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationArtistDTO.SubUnemployedDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Unemployed;
import org.springframework.stereotype.Component;

@Component
public class SubUnemployedMapper {
    public static Unemployed SubUnemployedDTOToUnemployed (SubUnemployedDTO subUnemployedDTO) {
        if (subUnemployedDTO == null) {
            return null;
        }

        Unemployed unemployed = new Unemployed();
        unemployed.setAllowance(subUnemployedDTO.getAllowance());

        return unemployed;
    }

    public static SubUnemployedDTO unemployedToSubUnemployedDTO (Unemployed unemployed) {
        if (unemployed == null) {
            return null;
        }

        SubUnemployedDTO subUnemployedDTO = new SubUnemployedDTO();
        subUnemployedDTO.setAllowance(unemployed.getAllowance());

        return subUnemployedDTO;
    }


}
