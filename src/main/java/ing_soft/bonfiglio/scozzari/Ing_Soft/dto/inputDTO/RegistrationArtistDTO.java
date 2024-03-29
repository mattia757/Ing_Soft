package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationArtistDTO.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationArtistDTO implements InputDTO{

    //From User
    //private SubUserDTO subUserDTO;

    //From Artist
    private SubArtistDTO subArtistDTO;

    //From Agenzia
    private SubAgencyDTO subAgencyDTO;

    //For Work
    private SubWorkDTO subWorkDTO;

    //For BankAccount
    private SubBankAccountDTO subBankAccountDTO;

    //From Unemployed
    //private SubUnemployedDTO subUnemployedDTO;

    //From TemporaryWork
    //private SubTemporaryWorkDTO subTemporaryWorkDTO;

    //From PermanentWork
    //private SubPermanentWorkDTO subPermanentWorkDTO;

    //From Italian BankAccount
    //private SubBankAccountITDTO subBankAccountITDTO;

    //From Foreign BankAccount
    //private SubBankAccountForeignDTO subBankAccountForeignDTO;

    //From Student
    //private SubStudentDTO subStudentDTO;

    //From Retired
    //private SubRetiredDTO subRetiredDTO;
}