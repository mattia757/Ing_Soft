package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationArtistDTO;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.*;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "WorkType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = SubUnemployedDTO.class, name = "Unemployed"),
        @JsonSubTypes.Type(value = SubTemporaryWorkDTO.class, name = "TemporaryWork"),
        @JsonSubTypes.Type(value = SubPermanentWorkDTO.class, name = "PermanentWork"),
        @JsonSubTypes.Type(value = SubStudentDTO.class, name = "Student"),
        @JsonSubTypes.Type(value = SubRetiredDTO.class, name = "Retired")
})
public interface SubWorkDTO {
}