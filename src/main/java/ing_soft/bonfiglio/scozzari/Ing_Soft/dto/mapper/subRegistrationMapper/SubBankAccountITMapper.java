package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.subRegistrationMapper;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationDTO.SubBankAccountDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.BankAccountIT;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class SubBankAccountITMapper {

    public static BankAccountIT mapToBankITAccount(SubBankAccountDTO subBankAccountDTO) {
        if (subBankAccountDTO == null) {
            return null;
        }

        BankAccountIT bankAccount = new BankAccountIT();

        bankAccount.setBeneficiaryName(subBankAccountDTO.getBeneficiaryName());
        bankAccount.setBankName(subBankAccountDTO.getBankName());
        bankAccount.setAbi(subBankAccountDTO.getAbi());
        bankAccount.setCab(subBankAccountDTO.getCab());
        bankAccount.setIban(subBankAccountDTO.getIban());

        return bankAccount;
    }

}
