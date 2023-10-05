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
        return SubUserMapper.mapToUser(registrationArtistDTO.getSubUserDTO());
    }

    public Artist getArtistFromDTO (RegistrationArtistDTO registrationArtistDTO){
        return SubArtistMapper.mapToArtist(registrationArtistDTO.getSubArtistDTO());
    }

    public Agency getAgencyFromDTO (RegistrationArtistDTO registrationArtistDTO){
        return SubAgencyMapper.mapToAgency(registrationArtistDTO.getSubAgencyDTO());
    }

    public BankAccountIT getBankAccountITFromDTO (RegistrationArtistDTO registrationArtistDTO){
        return SubBankAccountITMapper.mapToBankITAccount(registrationArtistDTO.getSubBankAccountDTO());
    }

    public BankAccountForeign getBankAccountForeignFromDTO (RegistrationArtistDTO registrationArtistDTO){
        return SubBankAccountForeignMapper.mapToBankForeignAccount(registrationArtistDTO.getSubBankAccountDTO());
    }

    public PermanentWork getPermanentWorkFromDTO (RegistrationArtistDTO registrationArtistDTO){
        return SubPermanentWorkMapper.mapToPermanentWork(registrationArtistDTO.getSubPermanentWorkDTO());
    }

    public TemporaryWork getTemporaryWorkFromDTO (RegistrationArtistDTO registrationArtistDTO){
        return SubTemporaryWorkMapper.mapToTemporaryWork(registrationArtistDTO.getSubTemporaryWorkDTO());
    }

    public Retired getRetiredFromDTO (RegistrationArtistDTO registrationArtistDTO){
        return SubRetiredMapper.mapToRetired(registrationArtistDTO.getSubRetiredDTO());
    }

    public Student getStudentFromDTO (RegistrationArtistDTO registrationArtistDTO){
        return SubStudentMapper.mapToStudent(registrationArtistDTO.getSubStudentDTO());
    }

    public Unemployed getUnemployedFromDTO (RegistrationArtistDTO registrationArtistDTO){
        return SubUnemployedMapper.mapToUnemployed(registrationArtistDTO.getSubUnemployedDTO());
    }
}