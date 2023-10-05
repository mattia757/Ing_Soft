package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubBankAccountDTO {

    private String beneficiaryName;
    private String bankName;
    private String abi;
    private String cab;
    private String iban;
    private String bicSwift;

}
