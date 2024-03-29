package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationArtistDTO.SubAgencyDTO;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "CustomType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = RegistrationArtistDTO.class, name = "registrationArtist"),
        @JsonSubTypes.Type(value = TheaterDTO.class, name = "registrationTheater"),
        @JsonSubTypes.Type(value = AgencyDTO.class, name = "registrationAgency"),
        @JsonSubTypes.Type(value = SeasonDTO.class, name = "registrationSeason"),
        @JsonSubTypes.Type(value = OperaDTO.class, name = "registrationOpera")
})
public interface InputDTO {

}
