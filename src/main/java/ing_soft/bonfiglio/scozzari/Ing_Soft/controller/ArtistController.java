package ing_soft.bonfiglio.scozzari.Ing_Soft.controller;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.InputDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.RegistrationArtistDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationArtistDTO.*;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.RegistrationArtistMapper;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.subRegistrationArtistMapper.SubUnemployedMapper;
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
                addWorkDTO(registrationArtistDTO);
                addBankAccount(registrationArtistDTO);
                addAgency(registrationArtistDTO);
                artistService.addArtist(registrationArtistMapper.getArtistFromDTO(registrationArtistDTO));
            }
            return ResponseEntity.status(HttpStatus.CREATED).body("Artist successfully created!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while creating the artist.");
        }
    }

    private void addWorkDTO(
            InputDTO registrationArtistDTO
    ) throws Exception {
        if(((RegistrationArtistDTO) registrationArtistDTO).getSubWorkDTO() instanceof SubUnemployedDTO){
            unemployedService.addUnemployed(registrationArtistMapper.getUnemployedFromDTO(registrationArtistDTO));
        } else if (((RegistrationArtistDTO) registrationArtistDTO).getSubWorkDTO() instanceof SubTemporaryWorkDTO) {
            temporaryWorkService.addTemporaryWork(registrationArtistMapper.getTemporaryWorkFromDTO(registrationArtistDTO));
        } else if (((RegistrationArtistDTO) registrationArtistDTO).getSubWorkDTO() instanceof SubPermanentWorkDTO) {
            permanentWorkService.addPermanentWork(registrationArtistMapper.getPermanentWorkFromDTO(registrationArtistDTO));
        } else if (((RegistrationArtistDTO) registrationArtistDTO).getSubWorkDTO() instanceof SubStudentDTO) {
            studentService.addStudent(registrationArtistMapper.getStudentFromDTO(registrationArtistDTO));
        } else if (((RegistrationArtistDTO) registrationArtistDTO).getSubWorkDTO() instanceof SubRetiredDTO) {
            retiredService.addRetired(registrationArtistMapper.getRetiredFromDTO(registrationArtistDTO));
        }
    }

    private void addBankAccount(
            InputDTO registrationArtistDTO
    ) throws Exception {
        if(((RegistrationArtistDTO) registrationArtistDTO).getSubBankAccountDTO() instanceof SubBankAccountITDTO){
            bankAccountITService.addBankAccountIT(registrationArtistMapper.getBankAccountITFromDTO(registrationArtistDTO));
        }
        if(((RegistrationArtistDTO) registrationArtistDTO).getSubBankAccountDTO() instanceof SubBankAccountForeignDTO){
            bankAccountForeignService.addBankAccountForeign(registrationArtistMapper.getBankAccountForeignFromDTO(registrationArtistDTO));
        }
    }

    private void addAgency(
            InputDTO registrationArtistDTO
    ) throws Exception {
        if(((RegistrationArtistDTO) registrationArtistDTO).getSubAgencyDTO() != null){
            agencyService.addAgency(registrationArtistMapper.getAgencyFromDTO(registrationArtistDTO));
        }
    }

}
