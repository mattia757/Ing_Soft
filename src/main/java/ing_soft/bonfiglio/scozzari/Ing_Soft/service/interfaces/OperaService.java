package ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.OperaDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Opera;

import java.util.Set;

public interface OperaService {

    void addOpera(Opera opera, Long idVenue, Long idSeason) throws Exception;
    void addArtists(Set<Long> idArtists, Long idOpera) throws Exception;
}
