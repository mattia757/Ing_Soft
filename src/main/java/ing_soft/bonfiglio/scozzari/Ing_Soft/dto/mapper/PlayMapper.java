package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.PlayDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Play;
import org.springframework.stereotype.Component;

@Component
public class PlayMapper {

    public static Play playDTOToPlay(PlayDTO playDTO) {
        Play play = new Play();

        play.setName(playDTO.getName());
        play.setDatePlay(playDTO.getDatePlay());

        return play;
    }

}
