package ing_soft.bonfiglio.scozzari.Ing_Soft.service.implementation;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.RegistrationArtistMapper;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Artist;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.TemporaryWork;
import ing_soft.bonfiglio.scozzari.Ing_Soft.repo.*;
import ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces.ArtistService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class ArtistServiceImpl implements ArtistService {

    //REPOSITORY
    private final ArtistRepository artistRepository;

    //MAPPER
    private final RegistrationArtistMapper registrationArtistMapper;
    @Override
    public void addArtist(Artist artist) throws Exception {
        if(artistRepository.findArtistByUsername(artist.getUser().getUsername()).isEmpty()) {
            artistRepository.save(artist);
        } else {
            throw new Exception("exception");
        }
    }

    @Override
    public void updateUserPassword(Long userId, String password) {

    }

    @Override
    public void deleteArtist(Long id) {

    }
}
