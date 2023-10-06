package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationDTO;


import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubTemporaryWorkDTO {

    @NotBlank(message = "Employer name cannot be empty")
    @Size(max = 255, message = "Employer name cannot be longer than 255 characters")
    private String employer;

    @NotBlank(message = "Deadline cannot be null")
    @Temporal(TemporalType.DATE)
    private LocalDate deadline;

    @NotBlank(message = "Revenue type cannot be null")
    private boolean isRevenueOver5000;
}
