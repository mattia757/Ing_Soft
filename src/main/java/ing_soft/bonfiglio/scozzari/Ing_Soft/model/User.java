package ing_soft.bonfiglio.scozzari.Ing_Soft.model;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.enums.UserRoles;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "The name cannot be empty")
    @NotNull(message = "The name cannot be null")
    @Pattern(regexp = "^[^- '](?=(?![A-Z]?[A-Z]))(?=(?![a-z]+[A-Z]))(?=(?!.*[A-Z][A-Z]))(?=(?!.*[- '][- '.]))(?=(?!.*[.][-'.]))[A-Za-z- '.]{2,}$")
    private String firstName;

    @Column(nullable = false)
    @NotBlank(message = "The surname cannot be empty")
    @NotNull(message = "The surname cannot be null")
    @Pattern(regexp = "^[^- '](?=(?![A-Z]?[A-Z]))(?=(?![a-z]+[A-Z]))(?=(?!.*[A-Z][A-Z]))(?=(?!.*[- '][- '.]))(?=(?!.*[.][-'.]))[A-Za-z- '.]{2,}$")
    private String lastName;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "The tax id code cannot be empty")
    @NotNull(message = "The tax id code name cannot be null")
    @Pattern(regexp = "^[a-zA-Z]{6}\\d{2}[a-zA-Z]\\d{2}[a-zA-Z]\\d{3}[a-zA-Z]$")
    private String taxIdCode;

    @Column(nullable = false , unique = true)
    @NotBlank(message = "The email cannot be empty")
    @NotNull(message = "The email cannot be null")
    @Email(message = "The email must respect the format")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:.[a-zA-Z0-9-]+)*$")
    private String email;

    @Column(nullable = false , unique = true)
    @NotBlank(message = "The username cannot be empty")
    @NotNull(message = "The username cannot be null")
    private String username;

    @Column(nullable = false)
    @NotBlank(message = "The password cannot be empty")
    @NotNull(message = "The password cannot be null")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRoles role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
