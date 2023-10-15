package ing_soft.bonfiglio.scozzari.Ing_Soft.repo;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.PermanentWork;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PermanentWorkRepository extends JpaRepository<PermanentWork, Long> {

    @NotNull Optional<PermanentWork> findById(@NotNull Long id);
}
