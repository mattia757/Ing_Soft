package ing_soft.bonfiglio.scozzari.Ing_Soft.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenueDTO {

    private String venue;

    private String cap;

    private String city;

    private Long capacity;

    private Long idTheater;
}
