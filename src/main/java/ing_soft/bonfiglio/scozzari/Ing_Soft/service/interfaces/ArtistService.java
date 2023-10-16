package ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Artist;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.interfaces.BankAccount;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.interfaces.Work;

import java.util.Set;

public interface ArtistService {

    void addArtist(Artist artist, Long idUser, Set<String> idTypology, Work work, BankAccount bankAccount) throws Exception;
    void updateUserPassword(Long userId, String password);
    void deleteArtist(Long id);

}
