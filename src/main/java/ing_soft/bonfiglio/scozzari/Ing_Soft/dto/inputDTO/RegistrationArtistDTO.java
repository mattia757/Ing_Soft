package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationArtistDTO.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationArtistDTO implements InputDTO{

    //From Artist
    private SubArtistDTO subArtistDTO;

    //From Agenzia
    //private SubAgencyDTO subAgencyDTO;

    //For Work
    private SubWorkDTO subWorkDTO;

    //For BankAccount
    private SubBankAccountDTO subBankAccountDTO;

}