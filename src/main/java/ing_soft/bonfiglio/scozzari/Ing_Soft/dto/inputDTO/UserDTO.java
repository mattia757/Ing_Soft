package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.enums.UserRoles;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Must be a valid email address")
    @Size(max = 255, message = "Email cannot exceed 255 characters")
    private String email;

    @NotBlank(message = "Password cannot be empty")
    @Size(max = 255, message = "Password cannot exceed 255 characters")
    private String password;

    @NotBlank(message = "Role cannot be empty")
    @Size(max = 50, message = "Role cannot exceed 50 characters")
    private UserRoles role;
}
