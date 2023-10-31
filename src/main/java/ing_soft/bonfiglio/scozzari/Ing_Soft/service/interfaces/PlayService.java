package ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.PlayDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Play;

public interface PlayService {
    void addPlay(Play play, Long idOpera) throws Exception;
}
