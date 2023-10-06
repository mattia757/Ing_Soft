package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubRetiredDTO {

        @NotBlank(message = "Pension type cannot be empty")
        private boolean isOver65;
}
