package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubStudentDTO {

        @NotBlank(message = "Name is mandatory")
        @Size(max = 255, message = "Name must be less than 255 characters")
        private String studies;
}
