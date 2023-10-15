package ing_soft.bonfiglio.scozzari.Ing_Soft.repo;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Unemployed;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UnemployedRepository extends JpaRepository<Unemployed, Long> {
    @NotNull Optional<Unemployed> findById(@NotNull Long id);
}
