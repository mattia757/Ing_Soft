package ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Agency;

import java.util.Set;

public interface AgencyService {

    void addAgency(Agency agency) throws Exception;

    void linkAgencyArtist(Long idAgency, Set<Long> idArtist);
}
