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
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "The name of the agency cannot be empty")
    @NotNull(message = "The name of the agency cannot be null")
    private String nameTheatre;

    @Column(nullable = false)
    @NotBlank(message = "The address phone number cannot be empty")
    @NotNull(message = "The address phone number cannot be null")
    private String address;

    @Column(nullable = false)
    @NotBlank(message = "The city phone number cannot be empty")
    @NotNull(message = "The city phone number cannot be null")
    private String city;

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
    @NotBlank(message = "The email cannot be empty")
    @NotNull(message = "The email cannot be null")
    @Email(message = "The email must respect the format")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:.[a-zA-Z0-9-]+)*$")
    private String pec;

    @Column(nullable = false)
    @NotBlank(message = "The unique code cannot be empty")
    @NotNull(message = "The unique code cannot be null")
    private String uniqueCode;

    @Column(nullable = false)
    @NotBlank(message = "The recipient code cannot be empty")
    @NotNull(message = "The recipient code cannot be null")
    private String recipientCode;

    @Column(nullable = false)
    @NotBlank(message = "The iva cannot be empty")
    @NotNull(message = "The iva cannot be null")
    private String iva;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "The tax id code cannot be empty")
    @NotNull(message = "The tax id code name cannot be null")
    @Pattern(regexp = "^[a-zA-Z]{6}\\d{2}[a-zA-Z]\\d{2}[a-zA-Z]\\d{3}[a-zA-Z]$")
    private String taxIdCodeTheatre;

    @Column(nullable = true)
    private String webSite;

}
