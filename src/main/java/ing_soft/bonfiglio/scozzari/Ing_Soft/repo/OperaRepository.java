package ing_soft.bonfiglio.scozzari.Ing_Soft.repo;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Opera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OperaRepository extends JpaRepository<Opera, Long> {

    @Query("SELECT opera FROM Opera opera WHERE opera.title = :title")
    Opera findOperaByTitle(String title);
}
