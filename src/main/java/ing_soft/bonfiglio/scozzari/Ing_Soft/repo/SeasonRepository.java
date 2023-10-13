package ing_soft.bonfiglio.scozzari.Ing_Soft.repo;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SeasonRepository extends JpaRepository<Season, Long> {

    @Query("SELECT season FROM Season season WHERE season.title = :title")
    Optional<Season> findSeasonByTitle(String title);
}
