package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.InputDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.PlayDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Play;
import org.springframework.stereotype.Component;

@Component
public class PlayMapper {

    public Play playDTOToPlay(InputDTO playDTO) {
        if (!(playDTO instanceof PlayDTO playData)) {
            return null;
        }
        Play play = new Play();

        play.setName(playData.getName());
        play.setDatePlay(playData.getDatePlay());

        return play;
    }

}
