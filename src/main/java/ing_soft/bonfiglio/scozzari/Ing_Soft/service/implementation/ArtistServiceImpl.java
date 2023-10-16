package ing_soft.bonfiglio.scozzari.Ing_Soft.service.implementation;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.AgencyDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationArtistDTO.SubArtistDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.RegistrationArtistMapper;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.subRegistrationArtistMapper.SubArtistMapper;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.*;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.interfaces.BankAccount;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.interfaces.Work;
import ing_soft.bonfiglio.scozzari.Ing_Soft.repo.*;
import ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces.ArtistService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
@AllArgsConstructor
public class ArtistServiceImpl implements ArtistService {

    //REPOSITORY
    private final ArtistRepository artistRepository;
    private final UserRepository userRepository;
    private final TypologyRepository typologyRepository;
    private final PermanentWorkRepository permanentWorkRepository;
    private final RetiredRepository retiredRepository;
    private final StudentRepository studentRepository;
    private final TemporaryWorkRepository temporaryWorkRepository;
    private final UnemployedRepository unemployedRepository;

    private final SubArtistMapper artistMapper;

    //MAPPER
    private final RegistrationArtistMapper registrationArtistMapper;
    @Override
    public void addArtist(
            Artist artist,
            Long idUser,
            Set<String> idTypologies,
            Work work,
            BankAccount bankAccount
    ) throws Exception {

        //setting fk user
        Optional<User> user = userRepository.findById(idUser);
        if(user.isEmpty()){
            throw new Exception("dio porco");
        }
        artist.setUser(user.get());
        System.out.println(artist);

        //set fk typology
        for(String idTypology : idTypologies){

            //set fk artist typology
            Typology typology = typologyRepository.findById(idTypology)
                    .orElseThrow(() -> new EntityNotFoundException("Typology not found with ID: " + idTypology));

            //set fk artist
            Set<Typology> typologies = artist.getTypologies() != null ? artist.getTypologies() : new HashSet<>();
            typologies.add(typology);
            artist.setTypologies(typologies);
        }

        if(work instanceof PermanentWork){
            artist.setPermanentWork((PermanentWork) work);
        }
        else if(work instanceof Retired){
            artist.setRetired((Retired) work);
        }
        else if(work instanceof Student){
            artist.setStudent((Student) work);
        }
        else if(work instanceof TemporaryWork){
            artist.setTemporaryWork((TemporaryWork) work);
        }
        else if(work instanceof Unemployed){
            artist.setUnemployed((Unemployed) work);
        }
        else {
            throw new Exception();
        }

        if(bankAccount instanceof BankAccountIT){
            ((BankAccountIT) bankAccount).setArtist(artist);
        }
        else if(bankAccount instanceof BankAccountForeign){
            ((BankAccountForeign) bankAccount).setArtist(artist);
        }
        else {
            throw new Exception();
        }

            artistRepository.save(artist);
    }

    @Override
    public void updateUserPassword(Long userId, String password) {

    }

    @Override
    public void deleteArtist(Long id) {

    }
}
