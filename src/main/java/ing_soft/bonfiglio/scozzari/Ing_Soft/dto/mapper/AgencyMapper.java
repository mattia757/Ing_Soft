package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.AgencyDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.InputDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Agency;
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
            agencyDTO.setAgencyPec(agency.getPec());
            agencyDTO.setAgencyPhone1(agency.getTel1());
            agencyDTO.setAgencyPhone2(agency.getTel2());
            agencyDTO.setWebsite(agency.getWebSite());

            return agencyDTO;
        }
    }

    public Agency agencyDTOToAgency (InputDTO agencyDTO){

        if (!(agencyDTO instanceof AgencyDTO agencyData))
            return null;
        else {
            Agency agency = new Agency();

            agency.setName(agencyData.getAgencyName());
            agency.setEmail(agencyData.getAgencyEmail());
            agency.setPec(agencyData.getAgencyPec());
            agency.setTel1(agencyData.getAgencyPhone1());
            agency.setTel2(agencyData.getAgencyPhone2());
            agency.setWebSite(agencyData.getWebsite());
            return agency;
        }
    }
}
