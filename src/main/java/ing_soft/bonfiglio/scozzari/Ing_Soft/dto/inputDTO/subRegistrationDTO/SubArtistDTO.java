package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationDTO;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Typology;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.enums.Occupation;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.enums.Taxation;
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

    private String gender;
    private LocalDate birthDate;
    private String birthPlace;
    private String birthState;
    private String educationTitle;

    private boolean isEuropean;
    private String stateOfCitizenship;

    private String cellPhone1;
    private String cellPhone2;
    private String pec;
    private String website;

    private String residence;
    private String postalCodeOfResidence;
    private String cityOfResidence;
    private String provinceOfResidence;
    private String regionOfResidence;
    private String stateOfResidence;
    private String domicile;
    private String postalCodeOfDomicile;
    private String cityOfDomicile;
    private String provinceOfDomicile;
    private String regionOfDomicile;
    private String stateOfDomicile;

    private String stageName;
    private Set<Typology> idTypology; // TODO Da attenzionare
    private String instrument;
    private String voice;

    private Boolean isIva;
    private Taxation taxation;
    private String iva;
    private Occupation occupation;
    private String inpsNumber;
    private Boolean memberFrom;
}
