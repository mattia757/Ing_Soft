package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.subRegistrationMapper;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationDTO.SubAgencyDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Agency;
import org.springframework.stereotype.Component;

@Component
public class SubAgencyMapper {

    public static Agency mapToAgency(SubAgencyDTO subAgencyDTO) {
        if (subAgencyDTO == null) {
            return null;
        }

        Agency agency = new Agency();

        agency.setName(subAgencyDTO.getAgencyName());
        agency.setEmail(subAgencyDTO.getAgencyEmail());
        agency.setTel1(subAgencyDTO.getAgencyPhone1());
        agency.setTel2(subAgencyDTO.getAgencyPhone2());

        return agency;
    }
}