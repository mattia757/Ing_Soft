package ing_soft.bonfiglio.scozzari.Ing_Soft.repo;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.VenueTheater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.Optional;

public interface VenueRepository extends JpaRepository<VenueTheater, Long> {

    @Query("SELECT venue FROM VenueTheater venue WHERE venue.venue = :venue")
    Optional<VenueTheater> findByVenue(String venue);
}
