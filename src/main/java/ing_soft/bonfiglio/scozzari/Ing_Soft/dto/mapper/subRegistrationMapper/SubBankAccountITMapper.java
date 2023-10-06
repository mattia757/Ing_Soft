package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.subRegistrationMapper;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationDTO.SubBankAccountDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.BankAccountIT;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class SubBankAccountITMapper {

    public static BankAccountIT bankITAccountToBankAccount (SubBankAccountDTO subBankAccountDTO) {
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

    public static SubBankAccountDTO bankITAccountToBankAccountDTO(SubBankAccountDTO subBankAccountDTO) {
        if (subBankAccountDTO == null) {
            return null;
        }

        SubBankAccountDTO bankAccountDTO = new SubBankAccountDTO();

        bankAccountDTO.setBeneficiaryName(subBankAccountDTO.getBeneficiaryName());
        bankAccountDTO.setBankName(subBankAccountDTO.getBankName());
        bankAccountDTO.setAbi(subBankAccountDTO.getAbi());
        bankAccountDTO.setCab(subBankAccountDTO.getCab());
        bankAccountDTO.setIban(subBankAccountDTO.getIban());

        return bankAccountDTO;
    }

}
