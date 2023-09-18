package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.UserRole;

public class UserDTO {

    private String email;
    private String password;
    private UserRole role;

    public UserDTO(String email, String password, UserRole role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getRole() {
        return role;
    }
}
