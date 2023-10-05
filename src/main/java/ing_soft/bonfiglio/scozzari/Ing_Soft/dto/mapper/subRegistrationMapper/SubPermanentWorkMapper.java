package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.subRegistrationMapper;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationDTO.SubPermanentWorkDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.PermanentWork;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class SubPermanentWorkMapper {

    public static PermanentWork mapToPermanentWork(SubPermanentWorkDTO subPermanentWorkDTO) {
        if (subPermanentWorkDTO == null) {
            return null;
        }

        PermanentWork permanentWork = new PermanentWork();
        permanentWork.setEmployer(subPermanentWorkDTO.getEmployer());
        permanentWork.setRevenueOver5000(subPermanentWorkDTO.isRevenueOver5000());

        return permanentWork;
    }

}
