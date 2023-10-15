package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationArtistDTO;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "BankAccountType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = SubBankAccountITDTO.class, name = "IT"),
        @JsonSubTypes.Type(value = SubBankAccountForeignDTO.class, name = "ES"),
})
public interface SubBankAccountDTO {
}
