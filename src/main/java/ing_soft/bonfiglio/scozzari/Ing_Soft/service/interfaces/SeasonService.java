package ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.SeasonDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Season;

public interface SeasonService {

    void addSeason(Season season, Long idTheater) throws Exception;
}
