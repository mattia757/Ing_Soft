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

@Service
@Transactional
@AllArgsConstructor
public class SeasonServiceImpl implements SeasonService {

    private final TheaterRepository theaterRepository;
    private final SeasonRepository seasonRepository;
    private final SeasonMapper seasonMapper;

    public void addSeason(SeasonDTO seasonDTO) throws Exception {
        // Prendo l'oggetto Theater dal DB con l'id passato nel JSON
        Theater theater = theaterRepository.findById(seasonDTO.getIdTheater())
                .orElseThrow(() -> new EntityNotFoundException("Theater not found with ID: " + seasonDTO.getIdTheater()));

        //Creo una lista di stagioni e aggiungo la stagione appena creata
        List<Season> seasons = theater.getSeasons();
        seasons.add(seasonMapper.seasonDTOToSeason(seasonDTO));

        //Aggiorno la lista di stagioni del teatro e salvo la stagione
        theater.setSeasons(seasons);

        //Setto la FK del teatro nella stagione
        seasonMapper.seasonDTOToSeason(seasonDTO).setTheater(theater);

        System.out.println(seasonDTO);

        //Salvo la stagione
        seasonRepository.save(seasonMapper.seasonDTOToSeason(seasonDTO));
    }
}