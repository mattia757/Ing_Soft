package ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.AgencyDTO;

public interface AgencyService {

    void addAgency(AgencyDTO agencyDTO) throws Exception;
    void deleteAgency(String name) throws Exception;
}
