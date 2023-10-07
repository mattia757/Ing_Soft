package ing_soft.bonfiglio.scozzari.Ing_Soft.service.implementation;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.TheaterMapper;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Theater;
import ing_soft.bonfiglio.scozzari.Ing_Soft.repo.TheaterRepository;
import ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces.TheaterService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class TheaterServiceImpl implements TheaterService {

    private final TheaterRepository theaterRepository;
    private final TheaterMapper theaterMapper;

    @Override
    public void addTheater(Theater theater) throws Exception {

        if(theaterRepository.findTheaterByName(theater.getName()).isEmpty()){
            theaterRepository.save(theater);
        }
        else{
            throw new Exception();
        }
    }
}
