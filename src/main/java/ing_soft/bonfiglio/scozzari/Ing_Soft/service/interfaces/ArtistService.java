package ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Artist;

public interface ArtistService {

    void addArtist(Artist artist) throws Exception;
    void updateUserPassword(Long userId, String password);
    void deleteArtist(Long id);

}
