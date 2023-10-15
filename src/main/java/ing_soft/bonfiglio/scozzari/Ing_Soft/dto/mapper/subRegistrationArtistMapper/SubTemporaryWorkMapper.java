package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.subRegistrationArtistMapper;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationArtistDTO.SubTemporaryWorkDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.TemporaryWork;
import org.springframework.stereotype.Component;

@Component
public class SubTemporaryWorkMapper {

    public static TemporaryWork subTemporaryWorkDTOToTemporaryWork (SubTemporaryWorkDTO subTemporaryWorkDTO) {
        if (subTemporaryWorkDTO == null) {
            return null;
        }

        TemporaryWork temporaryWork = new TemporaryWork();
        temporaryWork.setEmployer(subTemporaryWorkDTO.getEmployer());
        temporaryWork.setDeadline(subTemporaryWorkDTO.getDeadline());
        temporaryWork.setRevenueOver5000(subTemporaryWorkDTO.isRevenueOver5000());

        return temporaryWork;
    }

    public static SubTemporaryWorkDTO temporaryWorkToSubTemporaryWorkDTO (TemporaryWork temporaryWork) {
        if (temporaryWork == null) {
            return null;
        }

        SubTemporaryWorkDTO subTemporaryWorkDTO = new SubTemporaryWorkDTO();
        subTemporaryWorkDTO.setEmployer(temporaryWork.getEmployer());
        subTemporaryWorkDTO.setDeadline(temporaryWork.getDeadline());
        subTemporaryWorkDTO.setRevenueOver5000(temporaryWork.isRevenueOver5000());

        return subTemporaryWorkDTO;
    }


}
