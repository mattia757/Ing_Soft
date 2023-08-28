package ing_soft.bonfiglio.scozzari.Ing_Soft.repo;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    public Optional<User> getUserById(Long id);
    public Optional<User> getUserByUsername(String username);
    public Optional<User> getUserByEmail(String email);
    public Optional<User> getUserByCodiceFiscale(String codiceFiscale);

}
