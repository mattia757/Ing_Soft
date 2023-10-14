package ing_soft.bonfiglio.scozzari.Ing_Soft.service.implementation;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.AgencyDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.AgencyMapper;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Agency;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Artist;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.User;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.enums.AgencyRoles;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.middleTables.UserAgency;
import ing_soft.bonfiglio.scozzari.Ing_Soft.repo.AgencyRepository;
import ing_soft.bonfiglio.scozzari.Ing_Soft.repo.ArtistRepository;
import ing_soft.bonfiglio.scozzari.Ing_Soft.repo.UserAgencyRepository;
import ing_soft.bonfiglio.scozzari.Ing_Soft.repo.UserRepository;
import ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces.AgencyService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class AgencyServiceImpl implements AgencyService {

        private final AgencyRepository agencyRepository;
        private final ArtistRepository artistRepository;
        private final UserAgencyRepository userAgencyRepository;
        private final UserRepository userRepository;
        private final AgencyMapper agencyMapper;

        public void addAgency(AgencyDTO agencyDTO) throws Exception {
            List<Artist> artists = new ArrayList<>();
            Agency agency = agencyMapper.agencyDTOToAgency(agencyDTO);

            if (!agency.getName().isEmpty()) {
                for (Long idArtist : agencyDTO.getIdArtists()) {
                    //Aggiunta chiave esterna ArtistAgency
                    Artist artist = artistRepository.findById(idArtist)
                            .orElseThrow(() -> new EntityNotFoundException("Artist not found with ID: " + idArtist));
                    artist.getAgencies().add(agency); // Aggiungo l'agenzia all'artista
                    artists.add(artist);
                }

                //Aggiunta chiave esterna UserAgency

                List<UserAgency> userAgencies = new ArrayList<>();
                for (Long idUser : agencyDTO.getIdUsers()) {
                    User user = userRepository.findById(idUser)
                            .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + idUser));
                    UserAgency userAgency = new UserAgency();
                    userAgency.setUser(user);
                    userAgency.setAgency(agency);
                    userAgency.setRole(AgencyRoles.ADMIN);
                    userAgencies.add(userAgency);
                }
                agency.setArtists(artists); // Aggiungo gli artisti all'agenzia

                agencyRepository.save(agency);
                userAgencyRepository.saveAll(userAgencies);
            } else {
                throw new EntityNotFoundException("The name of the agency is empty");
            }
        }


        public void deleteAgency(String name) throws Exception {
            Agency agency = agencyRepository.findAgencyByName(name)
                    .orElseThrow(() -> new EntityNotFoundException("Agency not found with name: " + name));

            // Rimuovo l'agenzia dagli artisti
            for (Artist artist : agency.getArtists()) {
                artist.getAgencies().remove(agency);
            }

            // Rimuovi l'agenzia dagli utenti associati
            Optional<UserAgency> userAgencyOptional = userAgencyRepository.findUserAgencyByAgencyId(agency.getId());

            if (userAgencyOptional.isPresent()) {
                UserAgency userAgency = userAgencyOptional.get();
                userAgencyRepository.delete(userAgency);
            }
            else {
                throw new EntityNotFoundException("UserAgency not found with agencyId: " + agency.getId());
            }
        }

        public void updateAgency(AgencyDTO agencyDTO, String agencyName) throws Exception {
            Agency agency = agencyRepository.findAgencyByName(agencyName)
                    .orElseThrow(() -> new EntityNotFoundException("Agency not found with name: " + agencyName));

            agency.setName(agencyDTO.getAgencyName());
            agency.setEmail(agencyDTO.getAgencyEmail());
            agency.setPec(agencyDTO.getAgencyPec());
            agency.setTel1(agencyDTO.getAgencyPhone1());
            agency.setTel2(agencyDTO.getAgencyPhone2());
            agency.setWebSite(agencyDTO.getWebsite());

            agencyRepository.save(agency);
        }

        public Agency getAgencyByName(String name) throws Exception {
            return agencyRepository.findAgencyByName(name)
                    .orElseThrow(() -> new EntityNotFoundException("Agency not found with name: " + name));
        }

        public List<Agency> getAgencies() throws Exception {
            System.out.println("Repo: " + agencyRepository.findAllAgencies());

            return agencyRepository.findAllAgencies();
        }
}
