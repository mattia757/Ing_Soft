package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.InputDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.VenueDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.VenueTheater;
import org.springframework.stereotype.Component;

@Component
public class VenueMapper {

    public VenueTheater venueDTOToVenue (InputDTO venueDTO){

        if (!(venueDTO instanceof VenueDTO venueData))
            return null;
        else {
            VenueTheater venue = new VenueTheater();

            venue.setVenue(venueData.getVenue());
            venue.setCap(venueData.getCap());
            venue.setCity(venueData.getCity());
            venue.setCapacity(venueData.getCapacity());

            return venue;
        }
    }
}
