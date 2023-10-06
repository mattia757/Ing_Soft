package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgencyDTO {
    //TODO controllare Regex

    @NotBlank(message = "Name cannot be empty")
    @Size(max=255, message = "Name must be less than 255 characters")
    private String name;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Must be a valid email address")
    @Size(max=255, message = "Email must be less than 255 characters")
    private String email;

    @NotBlank(message = "PEC cannot be empty")
    @Email(message = "Must be a valid PEC address")
    @Size(max=255, message = "Pec must be less than 255 characters")
    private String pec;

    @NotBlank(message = "tel1 field cannot be empty")
    @Pattern(regexp = "\\d{10}", message = "Must be a valid phone number (10 digits)")
    private String tel1;

    @Pattern(regexp = "\\d{10}", message = "Must be a valid phone number (10 digits)")
    private String tel2;

    @Size(max=255, message = "Website must be less than 255 characters")
    private String website;

    private Long idArtist;
    private Long idUser;
}