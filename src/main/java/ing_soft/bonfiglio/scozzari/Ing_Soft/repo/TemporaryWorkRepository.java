package ing_soft.bonfiglio.scozzari.Ing_Soft.repo;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.TemporaryWork;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TemporaryWorkRepository extends JpaRepository<TemporaryWork, Long> {

    Optional<TemporaryWork> findById(TemporaryWork temporaryWork);
}
