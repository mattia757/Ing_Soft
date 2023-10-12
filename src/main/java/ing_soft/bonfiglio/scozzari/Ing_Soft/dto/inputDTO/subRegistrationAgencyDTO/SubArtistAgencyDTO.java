package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationAgencyDTO;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.InputDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubArtistAgencyDTO {

    @NotBlank(message = "Artist id is mandatory")
    private Long idArtist;

    @NotBlank(message = "Agency id is mandatory")
    private Long idAgency;
}
