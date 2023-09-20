package ing_soft.bonfiglio.scozzari.Ing_Soft.model;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.enums.TypologyOfArtists;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class Artist extends User{

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
    @NotNull(message = "The last name cannot be null")
    @Pattern(regexp = "^[^- '](?=(?![A-Z]?[A-Z]))(?=(?![a-z]+[A-Z]))(?=(?!.*[A-Z][A-Z]))(?=(?!.*[- '][- '.]))(?=(?!.*[.][-'.]))[A-Za-z- '.]{2,}$")
    private String lastName;

    @Column(nullable = false)
    @NotBlank(message = "The gender cannot be empty")
    @NotNull(message = "The gender cannot be null")
    @Pattern(regexp = "^(Male|Female|Other)$")
    private String gender;

    @Column(nullable = false)
    @NotBlank(message = "The date of birth cannot be empty")
    @NotNull(message = "The date of birth cannot be null")
    private LocalDate birthDate;

    @Column(nullable = false)
    @NotBlank(message = "The place of birth cannot be empty")
    @NotNull(message = "The place of birth cannot be null")
    private String birthPlace;

    @Column(nullable = false)
    @NotBlank(message = "The birth country cannot be empty or null")
    @NotNull(message = "The birth country cannot be empty or null")
    private String birthCountry;

    @Column(nullable = false)
    @NotBlank(message = "The education title cannot be empty")
    @NotNull(message = "The education title cannot be null")
    private String educationTitle;

    @Column(nullable = false)
    private boolean isStudent;

    @Column(nullable = false)
    private boolean isEuropean;

    @Column(nullable = false)
    @NotBlank(message = "The state of citizenship cannot be empty")
    @NotNull(message = "The state of citizenship cannot be null")
    private String stateOfCitizenship;

    @Column(nullable = false)
    @NotBlank(message = "The cell phone number cannot be empty")
    @NotNull(message = "The cell phone number cannot be null")
    private String cellPhoneNumber1;

    @Column
    private String cellPhoneNumber2;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "The email cannot be empty")
    @NotNull(message = "The email cannot be null")
    @Email(message = "The email must respect the format")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:.[a-zA-Z0-9-]+)*$")
    private String pec;

    @Column
    private String webSite;

    @Column(nullable = false)
    @NotBlank(message = "The residence cannot be empty")
    @NotNull(message = "The residence cannot be null")
    private String residence;

    @Column(nullable = false)
    @NotBlank(message = "The postcode of residence cannot be empty")
    @NotNull(message = "The postcode of residence cannot be null")
    private String postcodeOfResidence;

    @Column(nullable = false)
    @NotBlank(message = "The city of residence cannot be empty")
    @NotNull(message = "The city of residence cannot be null")
    private String cityOfResidence;

    @Column(nullable = false)
    @NotBlank(message = "The province of residence cannot be empty")
    @NotNull(message = "The province of residence cannot be null")
    private String provinceOfResidence;

    @Column(nullable = false)
    @NotBlank(message = "The region of residence cannot be empty")
    @NotNull(message = "The region of residence cannot be null")
    private String regionOfResidence;

    @Column(nullable = false)
    @NotBlank(message = "The state of residence cannot be empty")
    @NotNull(message = "The state of residence cannot be null")
    private String stateOfResidence;

    @Column(nullable = false)
    @NotBlank(message = "The domicile cannot be empty")
    @NotNull(message = "The domicile cannot be null")
    private String domicile;

    @Column(nullable = false)
    @NotBlank(message = "The postcode of domicile cannot be empty")
    @NotNull(message = "The postcode of domicile cannot be null")
    private String postcodeOfDomicile;

    @Column(nullable = false)
    @NotBlank(message = "The city of domicile cannot be empty")
    @NotNull(message = "The city of domicile cannot be null")
    private String cityOfDomicile;

    @Column(nullable = false)
    @NotBlank(message = "The province of domicile cannot be empty")
    @NotNull(message = "The province of domicile cannot be null")
    private String provinceOfDomicile;

    @Column(nullable = false)
    @NotBlank(message = "The region of domicile cannot be empty")
    @NotNull(message = "The region of domicile cannot be null")
    private String regionOfDomicile;

    @Column(nullable = false)
    @NotBlank(message = "The state of domicile cannot be empty")
    @NotNull(message = "The state of domicile cannot be null")
    private String stateOfDomicile;

    @Column(nullable = false)
    @NotBlank(message = "The stage name cannot be empty")
    @NotNull(message = "The stage name cannot be null")
    private String stageName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotBlank(message = "The artist typology cannot be empty")
    @NotNull(message = "The artist typology cannot be null")
    private TypologyOfArtists artistTypology;

    @Column(nullable = false)
    @NotBlank(message = "The instrument cannot be empty")
    @NotNull(message = "The instrument cannot be null")
    private String instrument;

    @AssertTrue(message = "L'utente deve essere maggiorenne")
    private boolean isAdult(){
        return Period.between(getBirthDate() , LocalDate.now()).getYears() >= 18;
    }

}
