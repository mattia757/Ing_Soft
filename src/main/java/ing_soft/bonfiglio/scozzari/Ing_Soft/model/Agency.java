package ing_soft.bonfiglio.scozzari.Ing_Soft.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "The name of the agency cannot be empty")
    @NotNull(message = "The name of the agency cannot be null")
    private String nameAgency;

    @Column(nullable = false)
    @NotBlank(message = "The cell phone number cannot be empty")
    @NotNull(message = "The cell phone number cannot be null")
    private String cellPhoneNumber1;

    @Column
    private String cellPhoneNumber2;

    @Column(nullable = false , unique = true)
    @NotBlank(message = "The email cannot be empty")
    @NotNull(message = "The email cannot be null")
    @Email(message = "The email must respect the format")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:.[a-zA-Z0-9-]+)*$")
    private String email;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "The pec cannot be empty")
    @NotNull(message = "The pec cannot be null")
    @Email(message = "The pec must respect the format")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:.[a-zA-Z0-9-]+)*$")
    private String pec;

    @Column(nullable = true)
    private String webSite;

}
