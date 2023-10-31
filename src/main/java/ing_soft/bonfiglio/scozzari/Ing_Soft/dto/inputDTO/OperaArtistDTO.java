package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperaArtistDTO implements InputDTO{

    private Set<Long> idArtists;
    private Long idOpera;
}
