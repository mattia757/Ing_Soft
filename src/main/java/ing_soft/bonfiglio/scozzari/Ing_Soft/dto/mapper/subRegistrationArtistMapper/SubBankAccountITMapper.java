package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.subRegistrationArtistMapper;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.InputDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationArtistDTO.SubBankAccountDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.BankAccountIT;
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
