package ing_soft.bonfiglio.scozzari.Ing_Soft.service.implementation;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.VenueMapper;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Theater;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.VenueTheater;
import ing_soft.bonfiglio.scozzari.Ing_Soft.repo.TheaterRepository;
import ing_soft.bonfiglio.scozzari.Ing_Soft.repo.VenueRepository;
import ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces.VenueService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class VenueServiceImpl implements VenueService {

    private final VenueRepository venueRepository;
    private final TheaterRepository theaterRepository;
    private final VenueMapper venueMapper;

    @Override
    public void addVenue(VenueTheater venue, Long idTheater) throws Exception {

        // Verifico se il teatro associato esiste
        Optional<Theater> theater = theaterRepository.findById(idTheater);
        if (theater.isEmpty()) {
            throw new Exception("Theater not found!");
        }
        // Setto la FK di teatro
        venue.setTheater(theater.get());

        venueRepository.save(venue);

    }
}
