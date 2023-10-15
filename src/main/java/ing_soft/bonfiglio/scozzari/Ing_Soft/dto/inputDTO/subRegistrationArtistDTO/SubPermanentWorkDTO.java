package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationArtistDTO;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.InputDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubPermanentWorkDTO implements SubWorkDTO {

        @NotBlank(message = "Employer name cannot be empty")
        @Size(max = 255, message = "Employer name cannot be longer than 255 characters")
        private String employer;

        @NotBlank(message = "Revenue type cannot be null")
        private Boolean revenue;

}