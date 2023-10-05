package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.subRegistrationMapper;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationDTO.SubBankAccountDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.BankAccountForeign;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.BankAccountIT;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class SubBankAccountForeignMapper {

    public static BankAccountForeign mapToBankForeignAccount(SubBankAccountDTO subBankAccountDTO) {
        if (subBankAccountDTO == null) {
            return null;
        }

        BankAccountForeign bankAccount = new BankAccountForeign();

        bankAccount.setBeneficiaryName(subBankAccountDTO.getBeneficiaryName());
        bankAccount.setIban(subBankAccountDTO.getIban());
        bankAccount.setBicSwift(subBankAccountDTO.getBicSwift());

        return bankAccount;
    }

}
