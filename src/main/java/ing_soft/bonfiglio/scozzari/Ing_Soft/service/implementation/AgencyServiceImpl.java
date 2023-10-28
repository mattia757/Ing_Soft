package ing_soft.bonfiglio.scozzari.Ing_Soft.service.implementation;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.AgencyMapper;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Agency;
import ing_soft.bonfiglio.scozzari.Ing_Soft.repo.AgencyRepository;
import ing_soft.bonfiglio.scozzari.Ing_Soft.repo.ArtistRepository;
import ing_soft.bonfiglio.scozzari.Ing_Soft.repo.UserAgencyRepository;
import ing_soft.bonfiglio.scozzari.Ing_Soft.repo.UserRepository;
import ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces.AgencyService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;

@Service
@Transactional
@AllArgsConstructor
public class AgencyServiceImpl implements AgencyService {

    private final AgencyRepository agencyRepository;
    private final ArtistRepository artistRepository;
    private final UserAgencyRepository userAgencyRepository;
    private final UserRepository userRepository;
    private final AgencyMapper agencyMapper;

    @Override
    public void addAgency(Agency agency) throws Exception {
        if(agencyRepository.findAgencyByName(agency.getName()).isEmpty()){
            agency.setCreatedAt(LocalDateTime.now());
            agencyRepository.save(agency);
        } else {
            throw new Exception("exception");
        }
    }

    @Override
    public void linkAgencyArtist(Long idAgency, Set<Long> idArtist) {
        agencyRepository.findById(idAgency).ifPresent(
                agency -> artistRepository.findAllById(idArtist).forEach(
                        artist -> {
                            agency.getArtists().add(artist);
                            artist.getAgencies().add(agency);
                        }
                )
        );
    }


}
