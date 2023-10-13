package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.VenueDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.VenueTheater;
import org.springframework.stereotype.Component;

@Component
public class VenueMapper {

    public VenueTheater venueDTOToVenue (VenueDTO venueDTO){

        if (venueDTO == null)
            return null;
        else {
            VenueTheater venue = new VenueTheater();

            venue.setVenue(venueDTO.getVenue());
            venue.setCap(venueDTO.getCap());
            venue.setCity(venueDTO.getCity());
            venue.setCapacity(venueDTO.getCapacity());

            return venue;
        }
    }
}
