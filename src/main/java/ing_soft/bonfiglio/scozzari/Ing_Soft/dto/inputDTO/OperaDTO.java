package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO;

import jakarta.persistence.Column;
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
public class OperaDTO {

    @NotBlank(message = "Title is mandatory")
    @Size(max = 50, message = "Title must be less than 50 characters")
    private String title;

    @NotBlank(message = "Author is mandatory")
    @Temporal(TemporalType.DATE)
    private LocalDate startDate;

    @NotBlank(message = "Author is mandatory")
    @Temporal(TemporalType.DATE)
    private LocalDate startRehearsal;

    private Long seasonId;
    private Long idVenue;
}
