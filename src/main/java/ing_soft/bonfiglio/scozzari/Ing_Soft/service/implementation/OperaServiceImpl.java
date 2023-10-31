package ing_soft.bonfiglio.scozzari.Ing_Soft.service.implementation;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.OperaDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.OperaMapper;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Artist;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Opera;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Season;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.VenueTheater;
import ing_soft.bonfiglio.scozzari.Ing_Soft.repo.ArtistRepository;
import ing_soft.bonfiglio.scozzari.Ing_Soft.repo.OperaRepository;
import ing_soft.bonfiglio.scozzari.Ing_Soft.repo.SeasonRepository;
import ing_soft.bonfiglio.scozzari.Ing_Soft.repo.VenueRepository;
import ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces.OperaService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
@AllArgsConstructor
public class OperaServiceImpl implements OperaService {

    private final OperaRepository operaRepository;
    private final VenueRepository venueRepository;
    private final SeasonRepository seasonRepository;
    private final ArtistRepository artistRepository;
    private final OperaMapper operaMapper;

    public void addOpera(Opera opera, Long idVenue, Long idSeason) throws Exception {
        Optional<VenueTheater> venue = venueRepository.findById(idVenue);
        Optional<Season> season = seasonRepository.findById(idSeason);

        if(venue.isEmpty()){
            throw new Exception("Venue not found");
        }
        if(season.isEmpty()){
            throw new Exception("Season not found");
        }
        opera.setVenue(venue.get());
        opera.setSeason(season.get());

        operaRepository.save(opera);
    }

    @Override
    public void addArtists(Set<Long> idArtists, Long idOpera) throws Exception {
        Optional<Opera> opera = operaRepository.findById(idOpera);
        if (opera.isEmpty()) {
            throw new Exception("Opera not found");
        }

        for (Long idArtist : idArtists) {
            Artist artist = artistRepository.findById(idArtist).orElseThrow(() -> new Exception("Artist not found"));

            // Aggiungi l'artista all'opera
            Set<Artist> operaArtists = opera.get().getArtists() != null ? opera.get().getArtists() : new HashSet<>();
            operaArtists.add(artist);
            opera.get().setArtists(operaArtists);

            // Aggiungi l'opera all'insieme delle opere dell'artista
            //Set<Opera> artistOperas = artist.getOperas() != null ? artist.getOperas() : new HashSet<>();
            //artistOperas.add(opera.get());
            //artist.setOperas(artistOperas);

            // Salva l'artista
            artistRepository.save(artist);
        }

        // Salva l'opera
        operaRepository.save(opera.get());
    }


}
