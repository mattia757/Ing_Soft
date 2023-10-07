package ing_soft.bonfiglio.scozzari.Ing_Soft.repo;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TheaterRepository extends JpaRepository<Theater, Long> {

    @Query("SELECT theater FROM Theater theater WHERE theater.name = :name")
    Optional<Theater> findTheaterByName(String name);

}
