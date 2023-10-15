package ing_soft.bonfiglio.scozzari.Ing_Soft.repo;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Retired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RetiredRepository extends JpaRepository<Retired, Long> {

    Optional<Retired> findById(Retired retired);

}
