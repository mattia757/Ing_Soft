package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.InputDTO;
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

    public User getUserFromDTO (InputDTO registrationArtistDTO){
        if (registrationArtistDTO instanceof RegistrationArtistDTO dto)
            return SubUserMapper.userDTOToUser(dto.getSubUserDTO());
        else
            throw new ClassCastException();
    }

    public Artist getArtistFromDTO (InputDTO registrationArtistDTO){
        if (registrationArtistDTO instanceof RegistrationArtistDTO dto)
            return SubArtistMapper.artistDTOToArtist(dto.getSubArtistDTO());
        else
            throw new ClassCastException();
    }

    public Agency getAgencyFromDTO (InputDTO registrationArtistDTO){
        if (registrationArtistDTO instanceof RegistrationArtistDTO dto)
            return SubAgencyMapper.agencyDTOToAgency(dto.getSubAgencyDTO());
        else
            throw new ClassCastException();
    }

    public BankAccountIT getBankAccountITFromDTO (InputDTO registrationArtistDTO){
        if (registrationArtistDTO instanceof RegistrationArtistDTO dto)
            return SubBankAccountITMapper.bankITAccountToBankAccount(dto.getSubBankAccountDTO());
        else
            throw new ClassCastException();
    }

    public BankAccountForeign getBankAccountForeignFromDTO (InputDTO registrationArtistDTO){
        if (registrationArtistDTO instanceof RegistrationArtistDTO dto)
            return SubBankAccountForeignMapper.subBankAccountDTOToBankAccount(dto.getSubBankAccountDTO());
        else
            throw new ClassCastException();
    }

    public PermanentWork getPermanentWorkFromDTO (InputDTO registrationArtistDTO){
        if (registrationArtistDTO instanceof RegistrationArtistDTO dto)
            return SubPermanentWorkMapper.subPermanentWorkDTOToPermanentWork(dto.getSubPermanentWorkDTO());
        else
            throw new ClassCastException();
    }

    public TemporaryWork getTemporaryWorkFromDTO (InputDTO registrationArtistDTO){
        if (registrationArtistDTO instanceof RegistrationArtistDTO dto)
            return SubTemporaryWorkMapper.subTemporaryWorkDTOToTemporaryWork(dto.getSubTemporaryWorkDTO());
        else
            throw new ClassCastException();
    }

    public Retired getRetiredFromDTO (InputDTO registrationArtistDTO){
        if (registrationArtistDTO instanceof RegistrationArtistDTO dto)
            return SubRetiredMapper.subArtistDTOToRetired(dto.getSubRetiredDTO());
        else
            throw new ClassCastException();
    }

    public Student getStudentFromDTO (InputDTO registrationArtistDTO){
        if (registrationArtistDTO instanceof RegistrationArtistDTO dto)
            return SubStudentMapper.subStudentDTOToStudent(dto.getSubStudentDTO());
        else
            throw new ClassCastException();
    }

    public Unemployed getUnemployedFromDTO (InputDTO registrationArtistDTO){
        if (registrationArtistDTO instanceof RegistrationArtistDTO dto)
            return SubUnemployedMapper.SubUnemployedDTOToUnemployed(dto.getSubUnemployedDTO());
        else
            throw new ClassCastException();
    }
}