package ing_soft.bonfiglio.scozzari.Ing_Soft.repo;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Agency;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.middleTables.UserAgency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserAgencyRepository extends JpaRepository<UserAgency, Long> {

    @Query("SELECT userAgency FROM UserAgency userAgency WHERE userAgency.agency.id = :agencyId")
    Optional<UserAgency> findUserAgencyByAgencyId(@Param("agencyId") Long agencyId);
}
