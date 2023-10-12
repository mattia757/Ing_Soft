package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationArtistDTO;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.InputDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubBankAccountDTO implements InputDTO {

    @NotBlank(message = "Beneficiary name cannot be empty")
    @Size(max = 255, message = "Beneficiary name must be at most 50 characters long")
    private String beneficiaryName;

    @NotBlank(message = "Bank name cannot be empty")
    @Size(max = 255, message = "Bank name must be at most 50 characters long")
    private String bankName;

    @NotBlank(message = "ABI cannot be empty")
    @Pattern(regexp = "\\d{5}", message = "Must be a valid ABI (5 digits)")
    @Size(min = 5, max = 5, message = "Must be a valid ABI (5 digits)")
    private String abi;

    @NotBlank(message = "CAB cannot be empty")
    @Pattern(regexp = "\\d{5}", message = "Must be a valid CAB (5 digits)")
    @Size(min = 5, max = 5, message = "Must be a valid CAB (5 digits)")
    private String cab;

    @NotBlank(message = "IBAN cannot be empty")
    @Size(min = 27, max = 27, message = "Must be a valid IBAN (27 characters)")
    private String iban;

    @NotBlank(message = "BIC/SWIFT cannot be empty")
    @Pattern(regexp = "[A-Z0-9]{8,11}", message = "Must be a valid BIC/SWIFT (8 to 11 characters)")
    @Size(min = 8, max = 11, message = "Must be a valid BIC/SWIFT (8 to 11 characters)")
    private String bicSwift;

}
