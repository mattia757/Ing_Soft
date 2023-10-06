package ing_soft.bonfiglio.scozzari.Ing_Soft.repo;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    @Query("SELECT artist FROM Artist artist JOIN artist.user user WHERE user.username = :username")
    Optional<Artist> findArtistByUsername(String username);
}
