package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO;


import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationArtistDTO.SubAgencyDTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgencyDTO implements InputDTO {

    @NotBlank(message = "Name cannot be empty")
    @Size(max=255, message = "Name must be less than 255 characters")
    private String agencyName;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Must be a valid email address")
    @Size(max=255, message = "Email must be less than 255 characters")
    private String agencyEmail;

    @NotBlank(message = "Pec cannot be empty")
    @Email(message = "Must be a valid Pec address")
    @Size(max=255, message = "Pec must be less than 255 characters")
    private String agencyPec;

    @NotBlank(message = "tel1 field cannot be empty")
    @Pattern(regexp = "\\d{10}", message = "Must be a valid phone number (10 digits)")
    private String agencyPhone1;

    @Pattern(regexp = "\\d{10}", message = "Must be a valid phone number (10 digits)")
    private String agencyPhone2;

    @Size(max=255, message = "Website must be less than 255 characters")
    private String website;

    private List<Long> idArtists;

    //TODO capire come gestirla, se creare agenzia e poi le utenze dei suoi dipendenti oppure in altri modi
    private List<Long> idUsers;
}