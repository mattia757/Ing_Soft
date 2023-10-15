package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationArtistDTO;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.InputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubUserDTO{

    private String name;
    private String surname;
    private String email;
    private String taxCode;

}
