package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.subRegistrationArtistMapper;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.InputDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationArtistDTO.SubBankAccountDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.BankAccountForeign;
import org.springframework.stereotype.Component;

@Component
public class SubBankAccountForeignMapper {

    public static BankAccountForeign subBankAccountDTOToBankAccount (SubBankAccountDTO subBankAccountDTO) {
        if (subBankAccountDTO == null) {
            return null;
        }

        BankAccountForeign bankAccount = new BankAccountForeign();

        bankAccount.setBeneficiaryName(subBankAccountDTO.getBeneficiaryName());
        bankAccount.setIban(subBankAccountDTO.getIban());
        bankAccount.setBicSwift(subBankAccountDTO.getBicSwift());

        return bankAccount;
    }

    public static SubBankAccountDTO bankAccountToSubBankAccountDTO(BankAccountForeign bankAccount) {
        if (bankAccount == null) {
            return null;
        }

        SubBankAccountDTO subBankAccountDTO = new SubBankAccountDTO();

        subBankAccountDTO.setBeneficiaryName(bankAccount.getBeneficiaryName());
        subBankAccountDTO.setIban(bankAccount.getIban());
        subBankAccountDTO.setBicSwift(bankAccount.getBicSwift());

        return subBankAccountDTO;
    }


}
