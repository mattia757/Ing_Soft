package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayDTO implements InputDTO {

    private String name;

    private LocalDate datePlay;

    private Long operaId;  // Campo per rappresentare l'ID dell'opera associata (Opera)
}
