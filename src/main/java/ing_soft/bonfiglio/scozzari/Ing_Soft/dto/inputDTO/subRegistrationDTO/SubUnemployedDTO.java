package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubUnemployedDTO {

    @NotBlank(message = "Please provide a valid allowance")
    private String allowance;
}