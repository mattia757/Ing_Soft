package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.enums.UserRoles;

public class UserDTO {

    private String email;
    private String password;
    private UserRoles role;

    public UserDTO(String email, String password, UserRoles role) {
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

    public UserRoles getRole() {
        return role;
    }
}
