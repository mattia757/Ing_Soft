package ing_soft.bonfiglio.scozzari.Ing_Soft.service.implementation;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.TheaterMapper;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.BaseEntity;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Theater;
import ing_soft.bonfiglio.scozzari.Ing_Soft.repo.TheaterRepository;
import ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces.TheaterService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
@AllArgsConstructor
public class TheaterServiceImpl implements TheaterService {

    private final TheaterRepository theaterRepository;
    private final TheaterMapper theaterMapper;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addTheater(Theater theater) throws Exception {

        if(theaterRepository.findTheaterByName(theater.getName()).isEmpty()){
            theater.setCreatedAt(LocalDateTime.now());
        }
        else{
            throw new Exception();
        }
    }

    @Override
    public void updateTheater(Long id, Theater theater) throws Exception {
        Optional<Theater> theaterToUpdate = theaterRepository.findById(id);
        if(theaterToUpdate.isPresent()){
            // Confronta gli attributi e aggiorna solo quelli modificati
            if (theater.getName() != null && !theater.getName().equals(theaterToUpdate.get().getName())) {
                theaterToUpdate.get().setName(theater.getName());
            }
            if (theater.getCity() != null && !theater.getCity().equals(theaterToUpdate.get().getCity())) {
                theaterToUpdate.get().setCity(theater.getCity());
            }
            if (theater.getTel() != null && !theater.getTel().equals(theaterToUpdate.get().getTel())) {
                theaterToUpdate.get().setTel(theater.getTel());
            }
            if (theater.getEmail() != null && !theater.getEmail().equals(theaterToUpdate.get().getEmail())) {
                theaterToUpdate.get().setEmail(theater.getEmail());
            }
            if (theater.getPec() != null && !theater.getPec().equals(theaterToUpdate.get().getPec())) {
                theaterToUpdate.get().setPec(theater.getPec());
            }
            if (theater.getTaxCode() != null && !theater.getTaxCode().equals(theaterToUpdate.get().getTaxCode())) {
                theaterToUpdate.get().setTaxCode(theater.getTaxCode());
            }
            if (theater.getWebSite() != null && !theater.getWebSite().equals(theaterToUpdate.get().getWebSite())) {
                theaterToUpdate.get().setWebSite(theater.getWebSite());
            }
            if (theater.getIva() != null && !theater.getIva().equals(theaterToUpdate.get().getIva())) {
                theaterToUpdate.get().setIva(theater.getIva());
            }
            if (theater.getUniqueCode() != null && !theater.getUniqueCode().equals(theaterToUpdate.get().getUniqueCode())) {
                theaterToUpdate.get().setUniqueCode(theater.getUniqueCode());
            }
            if (theater.getRecipientCode() != null && !theater.getRecipientCode().equals(theaterToUpdate.get().getRecipientCode())) {
                theaterToUpdate.get().setRecipientCode(theater.getRecipientCode());
            }

            theaterToUpdate.get().setUpdatedAt(LocalDateTime.now());
            theaterRepository.save(theaterToUpdate.get());
        }
        else{
            throw new Exception();
        }
    }

    @Override
    public void deleteTheater(Long id) throws Exception {
        Optional<Theater> theaterToDelete = theaterRepository.findById(id);
        if(theaterToDelete.isPresent()){
            theaterToDelete.get().setDeletedAt(LocalDateTime.now());

            System.out.println(theaterToDelete.get());
            theaterToDelete.get().getVenues()
                    .forEach(v -> v.setDeletedAt(LocalDateTime.now()));
        }
        else{
            throw new Exception();
        }

    }

    public void deleteEntity(Long idEntity) {
        BaseEntity entity = entityManager.find(BaseEntity.class, idEntity);
        entity.setDeletedAt(LocalDateTime.now());
        entityManager.merge(entity);
    }


    public void addArtistsToOpera(Long idTheater, Long idSeason, Long idOpera, Set<Long> idArtists) {

    }
}
