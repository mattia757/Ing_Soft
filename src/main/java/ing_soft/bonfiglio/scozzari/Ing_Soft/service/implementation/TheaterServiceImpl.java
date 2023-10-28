package ing_soft.bonfiglio.scozzari.Ing_Soft.service.implementation;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.TheaterMapper;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Opera;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Theater;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.User;
import ing_soft.bonfiglio.scozzari.Ing_Soft.repo.TheaterRepository;
import ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces.TheaterService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;

@Service
@Transactional
@AllArgsConstructor
public class TheaterServiceImpl implements TheaterService {

    private final TheaterRepository theaterRepository;
    private final TheaterMapper theaterMapper;

    @Override
    public void addTheater(Theater theater) throws Exception {

        if(theaterRepository.findTheaterByName(theater.getName()).isEmpty()){
            theater.setCreatedAt(LocalDateTime.now());
            theaterRepository.save(theater);
        }
        else{
            throw new Exception();
        }
    }

    public void addArtistsToOpera(Long idTheater, Long idSeason, Long idOpera, Set<Long> idArtists) {

    }
}
