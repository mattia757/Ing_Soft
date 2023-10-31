package ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.VenueTheater;

public interface VenueService {
    void addVenue(VenueTheater venue, Long idTheater) throws Exception;
}
