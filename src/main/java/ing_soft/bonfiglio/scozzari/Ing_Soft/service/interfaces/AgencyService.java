package ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.AgencyDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Agency;

public interface AgencyService {

    void addAgency(AgencyDTO agencyDTO) throws Exception;
}
