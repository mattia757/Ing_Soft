package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubAgencyDTO {

    private String agencyName;
    private String agencyEmail;
    private String agencyPhone1;
    private String agencyPhone2;
}