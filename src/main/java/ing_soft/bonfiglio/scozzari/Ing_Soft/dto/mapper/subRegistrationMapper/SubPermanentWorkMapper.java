package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.subRegistrationMapper;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationDTO.SubPermanentWorkDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.PermanentWork;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class SubPermanentWorkMapper {

    public static PermanentWork subPermanentWorkDTOToPermanentWork(SubPermanentWorkDTO subPermanentWorkDTO) {
        if (subPermanentWorkDTO == null) {
            return null;
        }

        PermanentWork permanentWork = new PermanentWork();
        permanentWork.setEmployer(subPermanentWorkDTO.getEmployer());
        permanentWork.setIsRevenueOver5000(subPermanentWorkDTO.getRevenue());

        return permanentWork;
    }

    public static SubPermanentWorkDTO permanentWorkToSubPermanentWorkDTO(PermanentWork permanentWork) {
        if (permanentWork == null) {
            return null;
        }

        SubPermanentWorkDTO subPermanentWorkDTO = new SubPermanentWorkDTO();

        subPermanentWorkDTO.setEmployer(permanentWork.getEmployer());
        subPermanentWorkDTO.setRevenue(permanentWork.getIsRevenueOver5000());

        return subPermanentWorkDTO;
    }


}
