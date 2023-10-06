package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.RegistrationArtistDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.subRegistrationMapper.*;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.*;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RegistrationArtistMapper{

    private SubAgencyMapper subAgencyMapper;
    private SubArtistMapper subArtistMapper;
    private SubBankAccountITMapper subBankAccountITMapper;
    private SubBankAccountForeignMapper subBankAccountForeignMapper;
    private SubStudentMapper subStudentMapper;
    private SubTemporaryWorkMapper subTemporaryWorkMapper;
    private SubUnemployedMapper subUnemployedMapper;
    private SubUserMapper subUserMapper;
    private SubRetiredMapper subRetiredMapper;
    private SubPermanentWorkMapper subPermanentWorkMapper;

    public User getUserFromDTO (RegistrationArtistDTO registrationArtistDTO){
        return SubUserMapper.userDTOToUser(registrationArtistDTO.getSubUserDTO());
    }

    public Artist getArtistFromDTO (RegistrationArtistDTO registrationArtistDTO){
        return SubArtistMapper.artistDTOToArtist(registrationArtistDTO.getSubArtistDTO());
    }

    public Agency getAgencyFromDTO (RegistrationArtistDTO registrationArtistDTO){
        return SubAgencyMapper.agencyDTOToAgency(registrationArtistDTO.getSubAgencyDTO());
    }

    public BankAccountIT getBankAccountITFromDTO (RegistrationArtistDTO registrationArtistDTO){
        return SubBankAccountITMapper.bankITAccountToBankAccount(registrationArtistDTO.getSubBankAccountDTO());
    }

    public BankAccountForeign getBankAccountForeignFromDTO (RegistrationArtistDTO registrationArtistDTO){
        return SubBankAccountForeignMapper.subBankAccountDTOToBankAccount(registrationArtistDTO.getSubBankAccountDTO());
    }

    public PermanentWork getPermanentWorkFromDTO (RegistrationArtistDTO registrationArtistDTO){
        return SubPermanentWorkMapper.subPermanentWorkDTOToPermanentWork(registrationArtistDTO.getSubPermanentWorkDTO());
    }

    public TemporaryWork getTemporaryWorkFromDTO (RegistrationArtistDTO registrationArtistDTO){
        return SubTemporaryWorkMapper.subTemporaryWorkDTOToTemporaryWork(registrationArtistDTO.getSubTemporaryWorkDTO());
    }

    public Retired getRetiredFromDTO (RegistrationArtistDTO registrationArtistDTO){
        return SubRetiredMapper.subArtistDTOToRetired(registrationArtistDTO.getSubRetiredDTO());
    }

    public Student getStudentFromDTO (RegistrationArtistDTO registrationArtistDTO){
        return SubStudentMapper.subStudentDTOToStudent(registrationArtistDTO.getSubStudentDTO());
    }

    public Unemployed getUnemployedFromDTO (RegistrationArtistDTO registrationArtistDTO){
        return SubUnemployedMapper.SubUnemployedDTOToUnemployed(registrationArtistDTO.getSubUnemployedDTO());
    }
}