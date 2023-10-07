package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "CustomType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = RegistrationArtistDTO.class, name = "registrationArtist"),
        @JsonSubTypes.Type(value = TheaterDTO.class, name = "registrationTheater"),
})
public interface InputDTO {

}
