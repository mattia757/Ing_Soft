package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TheaterDTO implements InputDTO{

    @NotBlank(message = "Name cannot be empty")
    @Size(max = 50, message = "Name cannot exceed 50 characters")
    private String name;

    @NotBlank(message = "City cannot be empty")
    @Size(max = 50, message = "City cannot exceed 50 characters")
    private String city;

    @NotBlank(message = "Phone cannot be empty")
    @Size(max = 20, message = "Phone cannot exceed 20 characters")
    private String tel;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Must be a valid email address")
    @Size(max = 255, message = "Email cannot exceed 255 characters")
    private String email;

    @NotBlank(message = "PEC cannot be empty")
    @Email(message = "Must be a valid PEC address")
    @Size(max = 255, message = "PEC cannot exceed 255 characters")
    private String pec;

    @NotBlank(message = "Tax code cannot be empty")
    @Size(max = 16, message = "Tax code cannot exceed 16 characters")
    private String taxCode;

    @NotBlank(message = "Website cannot be empty")
    @Size(max = 255, message = "Website cannot exceed 255 characters")
    private String website;

    @NotBlank(message = "IVA (VAT) cannot be empty")
    @Size(max = 11, message = "IVA (VAT) cannot exceed 11 characters")
    private String iva;

    @Size(max = 7, message = "Recipient code cannot exceed 7 characters")
    @UniqueElements
    private String recipientCode;

    @Size(max = 6, message = "Unique code cannot exceed 6 characters")
    @UniqueElements
    private String uniqueCode;
}
