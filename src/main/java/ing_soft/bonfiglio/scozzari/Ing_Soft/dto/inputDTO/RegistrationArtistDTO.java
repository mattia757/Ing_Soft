package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationDTO.*;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Artist;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationArtistDTO {

    //From User
    private SubUserDTO subUserDTO;

    //From Artist
    private SubArtistDTO subArtistDTO;

    //From Agenzia
    private SubAgencyDTO subAgencyDTO;

    //From Unemployed
    private SubUnemployedDTO subUnemployedDTO;

    //From TemporaryWork
    private SubTemporaryWorkDTO subTemporaryWorkDTO;

    //From PermanentWork
    private SubPermanentWorkDTO subPermanentWorkDTO;

    //From BankAccount
    private SubBankAccountDTO subBankAccountDTO;

    //From Student
    private SubStudentDTO subStudentDTO;

    //From Retired
    private SubRetiredDTO subRetiredDTO;
}