package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.AgencyDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.InputDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.subRegistrationArtistMapper.SubAgencyMapper;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Agency;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Artist;
import org.springframework.stereotype.Component;

@Component
public class AgencyMapper {

    public AgencyDTO agencyToAgencyDTO (Agency agency) {
        if (agency == null)
            return null;
        else {
            AgencyDTO agencyDTO = new AgencyDTO();

            agencyDTO.setAgencyName(agency.getName());
            agencyDTO.setAgencyEmail(agency.getEmail());
            agencyDTO.setAgencyPhone1(agency.getTel1());
            agencyDTO.setAgencyPhone2(agency.getTel2());
            agencyDTO.setWebsite(agency.getWebSite());

            return agencyDTO;
        }
    }

    public Agency agencyDTOToAgency (AgencyDTO agencyDTO){

        if (agencyDTO == null)
            return null;
        else {
            Agency agency = new Agency();

            agency.setName(agencyDTO.getAgencyName());
            agency.setEmail(agencyDTO.getAgencyEmail());
            agency.setPec(agencyDTO.getAgencyPec());
            agency.setTel1(agencyDTO.getAgencyPhone1());
            agency.setTel2(agencyDTO.getAgencyPhone2());
            agency.setWebSite(agencyDTO.getWebsite());

            return agency;
        }
    }
}
