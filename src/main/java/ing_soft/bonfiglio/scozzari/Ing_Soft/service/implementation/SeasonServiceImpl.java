package ing_soft.bonfiglio.scozzari.Ing_Soft.service.implementation;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.SeasonDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.SeasonMapper;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Season;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Theater;
import ing_soft.bonfiglio.scozzari.Ing_Soft.repo.SeasonRepository;
import ing_soft.bonfiglio.scozzari.Ing_Soft.repo.TheaterRepository;
import ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces.SeasonService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class SeasonServiceImpl implements SeasonService {

    private final TheaterRepository theaterRepository;
    private final SeasonRepository seasonRepository;
    private final SeasonMapper seasonMapper;

    @Override
    public void addSeason(Season season, Long idTheater) throws Exception {
        Optional<Theater> theater = theaterRepository.findById(idTheater);
        if (theater.isEmpty()){
            throw new EntityNotFoundException("Theater not found");
        }
        season.setTheater(theater.get());
        seasonRepository.save(season);
    }
}