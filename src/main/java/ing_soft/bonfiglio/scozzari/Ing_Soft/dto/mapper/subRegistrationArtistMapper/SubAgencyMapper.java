package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.subRegistrationArtistMapper;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.InputDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationArtistDTO.SubAgencyDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Agency;
import org.springframework.stereotype.Component;

@Component
public class SubAgencyMapper {

    public static Agency agencyDTOToAgency (SubAgencyDTO subAgencyDTO) {
        if (subAgencyDTO == null) {
            return null;
        }
        else {
            Agency agency = new Agency();

            agency.setName(subAgencyDTO.getAgencyName());
            agency.setEmail(subAgencyDTO.getAgencyEmail());
            agency.setTel1(subAgencyDTO.getAgencyPhone1());
            agency.setTel2(subAgencyDTO.getAgencyPhone2());
            agency.setWebSite(subAgencyDTO.getWebsite());

            return agency;
        }
    }

    public static SubAgencyDTO agencyToAgencyDTO (Agency agency) {
        if (agency == null) {
            return null;
        }
        else {
            SubAgencyDTO subAgencyDTO = new SubAgencyDTO();

            subAgencyDTO.setAgencyName(agency.getName());
            subAgencyDTO.setAgencyEmail(agency.getEmail());
            subAgencyDTO.setAgencyPhone1(agency.getTel1());
            subAgencyDTO.setAgencyPhone2(agency.getTel2());
            subAgencyDTO.setWebsite(agency.getWebSite());

            return subAgencyDTO;
        }
    }
}