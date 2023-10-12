package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationAgencyDTO.SubArtistAgencyDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationAgencyDTO.SubUserAgencyDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationArtistDTO.SubAgencyDTO;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "CustomType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = RegistrationArtistDTO.class, name = "registrationArtist"),
        @JsonSubTypes.Type(value = TheaterDTO.class, name = "registrationTheater"),
        @JsonSubTypes.Type(value = AgencyDTO.class, name = "registrationAgency"),
        @JsonSubTypes.Type(value = SubAgencyDTO.class, name = "registrationSubAgency"),
        @JsonSubTypes.Type(value = SubArtistAgencyDTO.class, name = "registrationSubArtistAgency"),
        @JsonSubTypes.Type(value = SubUserAgencyDTO.class, name = "registrationSubUserAgency"),
        @JsonSubTypes.Type(value = SubAgencyDTO.class, name = "registrationSubAgency")
})
public interface InputDTO {

}
