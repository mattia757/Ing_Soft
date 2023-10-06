package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationDTO;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Typology;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.enums.Occupation;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.enums.Taxation;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubArtistDTO {

    @NotBlank(message = "Gender is mandatory")
    private String gender;

    @NotBlank(message = "BirthDate is mandatory")
    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;

    @NotBlank(message = "BirthPlace is mandatory")
    @Size(max = 255, message = "BirthPlace must be less than 255 characters")
    private String birthPlace;

    @NotBlank(message = "BirthState is mandatory")
    @Size(max = 255, message = "BirthState must be less than 255 characters")
    private String birthState;

    @NotBlank(message = "BirthEducationTitle is mandatory")
    @Size(max = 255, message = "BirthEducationTitle must be less than 255 characters")
    private String educationTitle;

    @NotBlank(message = "BirthEducationInstitute is mandatory")
    private boolean isEuropean;

    @NotBlank(message = "BirthEducationInstitute is mandatory")
    private String stateOfCitizenship;

    @NotBlank(message = "Cell phone 1 cannot be empty")
    @Pattern(regexp = "\\d{10}", message = "Must be a valid phone number (10 digits)")
    private String cellPhone1;

    @Pattern(regexp = "\\d{10}", message = "Must be a valid phone number (10 digits)")
    private String cellPhone2;

    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Must be a valid PEC address")
    @Size(max = 255, message = "PEC must be less than 255 characters")
    private String pec;

    @Size(max = 255, message = "Website must be less than 255 characters")
    private String website;

    @NotBlank(message = "Residence cannot be empty")
    @Size(max = 255, message = "Residence must be less than 255 characters")
    private String residence;

    @NotBlank(message = "Postal code of residence cannot be empty")
    @Size(max = 10, message = "Postal code must be 10 characters")
    private String postalCodeOfResidence;

    @NotBlank(message = "City of residence cannot be empty")
    @Size(max = 255, message = "City of residence must be less than 255 characters")
    private String cityOfResidence;

    @NotBlank(message = "Province of residence cannot be empty")
    @Size(max = 255, message = "Province of residence must be less than 255 characters")
    private String provinceOfResidence;

    @NotBlank(message = "Region of residence cannot be empty")
    @Size(max = 255, message = "Region of residence must be less than 255 characters")
    private String regionOfResidence;

    @NotBlank(message = "State of residence cannot be empty")
    @Size(max = 255, message = "State of residence must be less than 255 characters")
    private String stateOfResidence;

    @NotBlank(message = "Domicile cannot be empty")
    @Size(max = 255, message = "Domicile must be less than 255 characters")
    private String domicile;

    @NotBlank(message = "Postal code of domicile cannot be empty")
    @Size(max = 10, message = "Postal code must be 10 characters")
    private String postalCodeOfDomicile;

    @NotBlank(message = "City of domicile cannot be empty")
    @Size(max = 255, message = "City of domicile must be less than 255 characters")
    private String cityOfDomicile;

    @NotBlank(message = "Province of domicile cannot be empty")
    @Size(max = 255, message = "Province of domicile must be less than 255 characters")
    private String provinceOfDomicile;

    @NotBlank(message = "Region of domicile cannot be empty")
    @Size(max = 255, message = "Region of domicile must be less than 255 characters")
    private String regionOfDomicile;

    @NotBlank(message = "State of domicile cannot be empty")
    @Size(max = 255, message = "State of domicile must be less than 255 characters")
    private String stateOfDomicile;

    @Size(max = 255, message = "Stage name must be less than 255 characters")
    private String stageName;

    private Set<Typology> idTypologies;

    @Size(max = 50, message = "Instrument must be less than 50 characters")
    private String instrument;

    @Size(max = 50, message = "Voice must be less than 50 characters")
    private String voice;

    private Long bankAccountITId;
    private Long bankAccountForeignId;

    @NotNull(message = "IsIva cannot be null")
    private Boolean isIva;

    @Size(max = 12, message = "Iva must be less than 12 characters")
    private String iva;

    private Taxation taxation;

    @Pattern(regexp = "\\d{10}", message = "Must be a valid INPS number (10 digits)")
    @NotBlank(message = "INPS number cannot be null")
    private String inpsNumber;

    @NotBlank(message = "Member from status cannot be null")
    private Boolean memberFrom;

    @NotBlank(message = "Occupation cannot be null")
    @Size(max = 255, message = "Occupation must be less than 255 characters")
    private Occupation occupation;

    private Long idUser;
}
