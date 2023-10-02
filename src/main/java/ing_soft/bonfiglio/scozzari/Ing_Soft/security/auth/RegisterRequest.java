package ing_soft.bonfiglio.scozzari.Ing_Soft.security.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String name;
    private String surname;
    private String taxCode;
    private String email;
    private String username;
    private String password;
}
