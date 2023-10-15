package ing_soft.bonfiglio.scozzari.Ing_Soft.repo;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.BankAccountForeign;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankAccountForeignRepository extends JpaRepository<BankAccountForeign, Long> {

    @NotNull Optional<BankAccountForeign> findById(@NotNull Long id);

}
