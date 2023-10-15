package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationArtistDTO;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.InputDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubUnemployedDTO implements SubWorkDTO {

    @NotBlank(message = "Please provide a valid allowance")
    private String allowance;

}