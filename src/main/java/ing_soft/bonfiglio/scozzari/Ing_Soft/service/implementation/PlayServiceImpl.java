package ing_soft.bonfiglio.scozzari.Ing_Soft.service.implementation;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.PlayDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.PlayMapper;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Opera;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Play;
import ing_soft.bonfiglio.scozzari.Ing_Soft.repo.OperaRepository;
import ing_soft.bonfiglio.scozzari.Ing_Soft.repo.PlayRepository;
import ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces.PlayService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class PlayServiceImpl implements PlayService {

    private final PlayRepository playRepository;
    private final OperaRepository operaRepository;
    private final PlayMapper playMapper;

    public void addPlay(Play play, Long idOpera) throws Exception {
        Optional<Opera> opera = operaRepository.findById(idOpera);
        if (opera.isEmpty()) {
            throw new Exception("Opera not found");
        }
        play.setOpera(opera.get());

        playRepository.save(play);
    }
}
