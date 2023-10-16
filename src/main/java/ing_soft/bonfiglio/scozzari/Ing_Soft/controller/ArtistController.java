package ing_soft.bonfiglio.scozzari.Ing_Soft.controller;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.InputDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.RegistrationArtistDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationArtistDTO.*;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.RegistrationArtistMapper;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.subRegistrationArtistMapper.SubUnemployedMapper;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.interfaces.BankAccount;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.interfaces.Work;
import ing_soft.bonfiglio.scozzari.Ing_Soft.service.implementation.*;
import ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces.PermanentWorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/artist")
public class ArtistController {

    //SERVICE
    @Autowired
    private ArtistServiceImpl artistService;
    @Autowired
    private UnemployedServiceImpl unemployedService;
    @Autowired
    private TemporaryWorkServiceImpl temporaryWorkService;
    @Autowired
    private PermanentWorkService permanentWorkService;
    @Autowired
    private StudentServiceImpl studentService;
    @Autowired
    private RetiredServiceImpl retiredService;
    @Autowired
    private BankAccountITServiceImpl bankAccountITService;
    @Autowired
    private BankAccountForeignServiceImpl bankAccountForeignService;
    @Autowired
    private AgencyServiceImpl agencyService;

    //MAPPER
    @Autowired
    private RegistrationArtistMapper registrationArtistMapper;

    @PostMapping(value = "/add")
    public ResponseEntity<String> create(
            @RequestBody InputDTO registrationArtistDTO
    ){
        try {
            System.out.println(registrationArtistDTO);
            if(registrationArtistDTO instanceof RegistrationArtistDTO){

                Work work = addWorkDTO(registrationArtistDTO);
                BankAccount bankAccount = addBankAccountDTO(registrationArtistDTO);
                //addAgency(registrationArtistDTO);
                artistService.addArtist(registrationArtistMapper.getArtistFromDTO(registrationArtistDTO),
                        ((RegistrationArtistDTO) registrationArtistDTO).getSubArtistDTO().getIdUser(),
                        ((RegistrationArtistDTO) registrationArtistDTO).getSubArtistDTO().getIdTypologies(), work, bankAccount);
            }
            return ResponseEntity.status(HttpStatus.CREATED).body("Artist successfully created!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while creating the artist.");
        }
    }

    private Work addWorkDTO(
            InputDTO registrationArtistDTO
    ) throws Exception {
        if(((RegistrationArtistDTO) registrationArtistDTO).getSubWorkDTO() instanceof SubUnemployedDTO){
            return unemployedService.addUnemployed(registrationArtistMapper.getUnemployedFromDTO(registrationArtistDTO));
        } else if (((RegistrationArtistDTO) registrationArtistDTO).getSubWorkDTO() instanceof SubTemporaryWorkDTO) {
            return temporaryWorkService.addTemporaryWork(registrationArtistMapper.getTemporaryWorkFromDTO(registrationArtistDTO));
        } else if (((RegistrationArtistDTO) registrationArtistDTO).getSubWorkDTO() instanceof SubPermanentWorkDTO) {
            return permanentWorkService.addPermanentWork(registrationArtistMapper.getPermanentWorkFromDTO(registrationArtistDTO));
        } else if (((RegistrationArtistDTO) registrationArtistDTO).getSubWorkDTO() instanceof SubStudentDTO) {
            return studentService.addStudent(registrationArtistMapper.getStudentFromDTO(registrationArtistDTO));
        } else if (((RegistrationArtistDTO) registrationArtistDTO).getSubWorkDTO() instanceof SubRetiredDTO) {
            return retiredService.addRetired(registrationArtistMapper.getRetiredFromDTO(registrationArtistDTO));
        }
        throw new Exception("lavoro non trovato");
    }

    private BankAccount addBankAccountDTO(
            InputDTO registrationArtistDTO
    ) throws Exception {
        if(((RegistrationArtistDTO) registrationArtistDTO).getSubBankAccountDTO() instanceof SubBankAccountITDTO){
            return bankAccountITService.addBankAccountIT(registrationArtistMapper.getBankAccountITFromDTO(registrationArtistDTO));
        }
        if(((RegistrationArtistDTO) registrationArtistDTO).getSubBankAccountDTO() instanceof SubBankAccountForeignDTO){
            return bankAccountForeignService.addBankAccountForeign(registrationArtistMapper.getBankAccountForeignFromDTO(registrationArtistDTO));
        }
        throw new Exception("conto bancario non trovato");
    }

    /*private void addAgency(
            InputDTO registrationArtistDTO
    ) throws Exception {
        if(((RegistrationArtistDTO) registrationArtistDTO).getSubAgencyDTO() != null){
            agencyService.addAgency(registrationArtistMapper.getAgencyFromDTO(registrationArtistDTO));
        }
    }*/

}
