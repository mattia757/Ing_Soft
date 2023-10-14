package ing_soft.bonfiglio.scozzari.Ing_Soft.repo;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface AgencyRepository extends JpaRepository<Agency, Long> {

    @Query("SELECT agency FROM Agency agency WHERE agency.name = :name")
    Optional<Agency> findAgencyByName(String name);

    @Query("SELECT agency FROM Agency agency")
    List<Agency> findAllAgencies();
}
