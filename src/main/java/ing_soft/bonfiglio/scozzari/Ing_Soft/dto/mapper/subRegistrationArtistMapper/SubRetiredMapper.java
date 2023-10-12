package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.subRegistrationArtistMapper;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.InputDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationArtistDTO.SubRetiredDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Retired;
import org.springframework.stereotype.Component;

@Component
public class SubRetiredMapper {

    public static Retired subArtistDTOToRetired(SubRetiredDTO subRetiredDTO) {
        if (subRetiredDTO == null) {
            return null;
        }

        Retired retired = new Retired();
        retired.setOver65(subRetiredDTO.isOver65());

        return retired;
    }

    public static SubRetiredDTO retiredToSubRetiredDTO(Retired retired) {
        if (retired == null) {
            return null;
        }

        SubRetiredDTO subRetiredDTO = new SubRetiredDTO();
        subRetiredDTO.setOver65(retired.isOver65());

        return subRetiredDTO;
    }
}
