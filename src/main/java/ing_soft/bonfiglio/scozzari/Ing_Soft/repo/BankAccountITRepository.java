package ing_soft.bonfiglio.scozzari.Ing_Soft.repo;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.BankAccountIT;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankAccountITRepository extends JpaRepository<BankAccountIT, Long> {
    @NotNull Optional<BankAccountIT> findById(@NotNull Long id);
}
