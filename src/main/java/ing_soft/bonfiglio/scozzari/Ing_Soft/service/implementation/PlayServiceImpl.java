package ing_soft.bonfiglio.scozzari.Ing_Soft.service.implementation;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.PlayDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.PlayMapper;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Opera;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Play;
import ing_soft.bonfiglio.scozzari.Ing_Soft.repo.PlayRepository;
import ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces.PlayService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class PlayServiceImpl implements PlayService {

    private final PlayRepository playRepository;
    private final PlayMapper playMapper;

    public void addPlay(PlayDTO playDTO) throws Exception {
        Play play = playMapper.playDTOToPlay(playDTO);

        Opera opera = new Opera();
        opera.setId(playDTO.getOperaId());
        play.setOpera(opera);

        playRepository.save(play);
    }
}
