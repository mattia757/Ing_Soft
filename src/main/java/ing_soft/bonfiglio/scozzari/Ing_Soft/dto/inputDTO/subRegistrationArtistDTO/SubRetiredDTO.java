package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationArtistDTO;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.InputDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubRetiredDTO implements SubWorkDTO {

        @NotBlank(message = "Pension type cannot be empty")
        private boolean isOver65;

}
