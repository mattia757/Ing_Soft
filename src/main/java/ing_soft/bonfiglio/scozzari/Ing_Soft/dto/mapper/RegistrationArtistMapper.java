package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.InputDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.RegistrationArtistDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationArtistDTO.*;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.subRegistrationArtistMapper.*;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class RegistrationArtistMapper{


    //private SubAgencyMapper subAgencyMapper;

    private SubArtistMapper subArtistMapper;
    private SubBankAccountITMapper subBankAccountITMapper;
    private SubBankAccountForeignMapper subBankAccountForeignMapper;
    private SubStudentMapper subStudentMapper;
    private SubTemporaryWorkMapper subTemporaryWorkMapper;
    private SubUnemployedMapper subUnemployedMapper;

    //private SubUserMapper subUserMapper;

    private SubRetiredMapper subRetiredMapper;
    private SubPermanentWorkMapper subPermanentWorkMapper;

    /*public User getUserFromDTO (InputDTO registrationArtistDTO){
        if (registrationArtistDTO instanceof RegistrationArtistDTO dto)
            return SubUserMapper.userDTOToUser(dto.getSubUserDTO());
        else
            throw new ClassCastException();
    }*/

    public Artist getArtistFromDTO (InputDTO registrationArtistDTO){
        if (registrationArtistDTO instanceof RegistrationArtistDTO dto)
            return SubArtistMapper.artistDTOToArtist(dto.getSubArtistDTO());
        else
            throw new ClassCastException();
    }

    /*public Agency getAgencyFromDTO (InputDTO registrationArtistDTO){
        if (registrationArtistDTO instanceof RegistrationArtistDTO dto)
            return SubAgencyMapper.agencyDTOToAgency(dto.getSubAgencyDTO());
        else
            throw new ClassCastException();
    }*/

    public BankAccountIT getBankAccountITFromDTO(InputDTO registrationArtistDTO) {
        if (registrationArtistDTO instanceof RegistrationArtistDTO) {
            SubBankAccountDTO subBankAccountDTO = ((RegistrationArtistDTO) registrationArtistDTO).getSubBankAccountDTO();
            if (subBankAccountDTO instanceof SubBankAccountITDTO) {
                return SubBankAccountITMapper.SubBankAccountITDTOToBankAccountIT((SubBankAccountITDTO) subBankAccountDTO);
            } else {
                throw new ClassCastException();
            }
        } else {
            throw new ClassCastException();
        }
    }

    public BankAccountForeign getBankAccountForeignFromDTO(InputDTO registrationArtistDTO) {
        if (registrationArtistDTO instanceof RegistrationArtistDTO) {
            SubBankAccountDTO subBankAccountDTO = ((RegistrationArtistDTO) registrationArtistDTO).getSubBankAccountDTO();
            if (subBankAccountDTO instanceof SubBankAccountForeignDTO) {
                return SubBankAccountForeignMapper.subBankAccountForeignDTOToBankAccountForeign((SubBankAccountForeignDTO) subBankAccountDTO);
            } else {
                throw new ClassCastException();
            }
        } else {
            throw new ClassCastException();
        }
    }

    public PermanentWork getPermanentWorkFromDTO(InputDTO registrationArtistDTO) {
        if (registrationArtistDTO instanceof RegistrationArtistDTO) {
            SubWorkDTO subWorkDTO = ((RegistrationArtistDTO) registrationArtistDTO).getSubWorkDTO();
            if (subWorkDTO instanceof SubPermanentWorkDTO) {
                return SubPermanentWorkMapper.subPermanentWorkDTOToPermanentWork((SubPermanentWorkDTO) subWorkDTO);
            } else {
                throw new ClassCastException();
            }
        } else {
            throw new ClassCastException();
        }
    }

    public TemporaryWork getTemporaryWorkFromDTO(InputDTO registrationArtistDTO) {
        if (registrationArtistDTO instanceof RegistrationArtistDTO) {
            SubWorkDTO subWorkDTO = ((RegistrationArtistDTO) registrationArtistDTO).getSubWorkDTO();
            if (subWorkDTO instanceof SubTemporaryWorkDTO) {
                return SubTemporaryWorkMapper.subTemporaryWorkDTOToTemporaryWork((SubTemporaryWorkDTO) subWorkDTO);
            } else {
                throw new ClassCastException();
            }
        } else {
            throw new ClassCastException();
        }
    }

    public Retired getRetiredFromDTO(InputDTO registrationArtistDTO) {
        if (registrationArtistDTO instanceof RegistrationArtistDTO) {
            SubWorkDTO subWorkDTO = ((RegistrationArtistDTO) registrationArtistDTO).getSubWorkDTO();
            if (subWorkDTO instanceof SubRetiredDTO) {
                return SubRetiredMapper.subRetiredDTOToRetired((SubRetiredDTO) subWorkDTO);
            } else {
                throw new ClassCastException();
            }
        } else {
            throw new ClassCastException();
        }
    }

    public Student getStudentFromDTO(InputDTO registrationArtistDTO) {
        if (registrationArtistDTO instanceof RegistrationArtistDTO) {
            SubWorkDTO subWorkDTO = ((RegistrationArtistDTO) registrationArtistDTO).getSubWorkDTO();
            if (subWorkDTO instanceof SubStudentDTO) {
                return SubStudentMapper.subStudentDTOToStudent((SubStudentDTO) subWorkDTO);
            } else {
                throw new ClassCastException();
            }
        } else {
            throw new ClassCastException();
        }
    }

    public Unemployed getUnemployedFromDTO(InputDTO registrationArtistDTO) {
        if (registrationArtistDTO instanceof RegistrationArtistDTO) {
            SubWorkDTO subWorkDTO = ((RegistrationArtistDTO) registrationArtistDTO).getSubWorkDTO();
            if (subWorkDTO instanceof SubUnemployedDTO) {
                return SubUnemployedMapper.SubUnemployedDTOToUnemployed((SubUnemployedDTO) subWorkDTO);
            } else {
                throw new ClassCastException();
            }
        } else {
            throw new ClassCastException();
        }
    }

}