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
import java.util.Optional;
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
    public void updateAgency(Agency agency, Long idAgency) throws Exception {
        Optional<Agency> agencyOptional = agencyRepository.findById(idAgency);

        if(agencyOptional.isPresent()){
            Agency agencyToUpdate = agencyOptional.get();

            // Confronta gli attributi e aggiorna solo quelli modificati
            if (agency.getName() != null && !agency.getName().equals(agencyToUpdate.getName())) {
                agencyToUpdate.setName(agency.getName());
            }

            if (agency.getEmail() != null && !agency.getEmail().equals(agencyToUpdate.getEmail())) {
                agencyToUpdate.setEmail(agency.getEmail());
            }

            if (agency.getPec() != null && !agency.getPec().equals(agencyToUpdate.getPec())) {
                agencyToUpdate.setPec(agency.getPec());
            }

            if (agency.getTel1() != null && !agency.getTel1().equals(agencyToUpdate.getTel1())) {
                agencyToUpdate.setTel1(agency.getTel1());
            }

            if (agency.getTel2() != null && !agency.getTel2().equals(agencyToUpdate.getTel2())) {
                agencyToUpdate.setTel2(agency.getTel2());
            }

            if (agency.getWebSite() != null && !agency.getWebSite().equals(agencyToUpdate.getWebSite())) {
                agencyToUpdate.setWebSite(agency.getWebSite());
            }

            agencyToUpdate.setUpdatedAt(LocalDateTime.now());
            agencyRepository.save(agencyToUpdate);
        } else {
            throw new Exception("exception");
        }
    }

    @Override
    public void deleteAgency(Long id) throws Exception {
        Optional<Agency> agency = agencyRepository.findById(id);
        if(agency.isPresent()){
            agency.get().setDeletedAt(LocalDateTime.now());
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
