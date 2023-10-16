package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationArtistDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubAgencyDTO{

    /*

    @NotBlank(message = "Name cannot be empty")
    @Size(max=255, message = "Name must be less than 255 characters")
    private String agencyName;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Must be a valid email address")
    @Size(max=255, message = "Email must be less than 255 characters")
    private String agencyEmail;

    @NotBlank(message = "tel1 field cannot be empty")
    @Pattern(regexp = "\\d{10}", message = "Must be a valid phone number (10 digits)")
    private String agencyPhone1;

    @Pattern(regexp = "\\d{10}", message = "Must be a valid phone number (10 digits)")
    private String agencyPhone2;

    @Size(max=255, message = "Website must be less than 255 characters")
    private String website;

    @Email(message = "Must be a valid email address")
    @Size(max=255, message = "Email must be less than 255 characters")
    private String agencyPec;

    */

    private Set<Long> idAgency;

}