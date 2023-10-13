package ing_soft.bonfiglio.scozzari.Ing_Soft.service.implementation;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.VenueDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.VenueMapper;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Theater;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.VenueTheater;
import ing_soft.bonfiglio.scozzari.Ing_Soft.repo.VenueRepository;
import ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces.VenueService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class VenueServiceImpl implements VenueService {

    private final VenueRepository venueRepository;
    private final VenueMapper venueMapper;

    public void addVenue(VenueDTO venueDTO) throws Exception {
        VenueTheater venue = venueMapper.venueDTOToVenue(venueDTO);

        Theater theater = new Theater();
        theater.setId(venueDTO.getIdTheater());

        venue.setTheater(theater); //Set id Theater

        venueRepository.save(venue);
    }
}
