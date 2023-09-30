package ing_soft.bonfiglio.scozzari.Ing_Soft.model;

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
public class Artist{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "The gender cannot be empty")
    @NotNull(message = "The gender cannot be null")
    @Pattern(regexp = "^(Maschio|Femmina|Altro)$")
    private String gender;
    //TODO Enum for gender

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
    private boolean isEuropean;

    @Column(nullable = false)
    @NotBlank(message = "The state of citizenship cannot be empty")
    @NotNull(message = "The state of citizenship cannot be null")
    private String stateOfCitizenship;
    //TODO Enum

    @Column(nullable = false)
    @NotBlank(message = "The cell phone number cannot be empty")
    @NotNull(message = "The cell phone number cannot be null")
    private String cellPhone1;

    @Column(nullable = true)
    private String cellPhone2;

    @Column(nullable = true, unique = true)
    @Email(message = "The pec must respect the format")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:.[a-zA-Z0-9-]+)*$")
    private String pec;

    @Column(nullable = true)
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

    @Column(nullable = true)
    @NotBlank(message = "The stage name cannot be empty")
    @NotNull(message = "The stage name cannot be null")
    private String stageName;

    @Column(nullable = false)
    @NotBlank(message = "The artist typology cannot be empty")
    @NotNull(message = "The artist typology cannot be null")
    private Integer idTypology;
    //TODO FK Table Typology

    @Column(nullable = true)
    @NotBlank(message = "The instrument cannot be empty")
    @NotNull(message = "The instrument cannot be null")
    private String instrument;

    private String voice; //TODO

    //TODO Bank Account

    //TODO Fisco

    @AssertTrue(message = "L'utente deve essere maggiorenne")
    private boolean isAdult(){
        return Period.between(getBirthDate() , LocalDate.now()).getYears() >= 18;
    }

}
