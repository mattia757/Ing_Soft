package ing_soft.bonfiglio.scozzari.Ing_Soft.service.implementation;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.OperaDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.OperaMapper;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Opera;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Season;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.VenueTheater;
import ing_soft.bonfiglio.scozzari.Ing_Soft.repo.ArtistRepository;
import ing_soft.bonfiglio.scozzari.Ing_Soft.repo.OperaRepository;
import ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces.OperaService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class OperaServiceImpl implements OperaService {

    private final OperaRepository operaRepository;
    private final OperaMapper operaMapper;

    public void addOpera(OperaDTO operaDTO) throws Exception {
        Opera opera = operaMapper.operaDTOToOpera(operaDTO);

        opera.setTitle(operaDTO.getTitle());
        opera.setStartDate(operaDTO.getStartDate());
        opera.setStartRehearsal(operaDTO.getStartRehearsal());


        //Set FK Venue e Season
        Season season = new Season();
        season.setId(operaDTO.getSeasonId());

        VenueTheater venue = new VenueTheater();
        venue.setId(operaDTO.getIdVenue());

        opera.setSeason(season);
        opera.setVenue(venue);

        operaRepository.save(opera);
    }
}
