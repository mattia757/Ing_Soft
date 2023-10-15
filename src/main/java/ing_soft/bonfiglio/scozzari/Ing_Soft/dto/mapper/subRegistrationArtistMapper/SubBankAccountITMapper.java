package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.subRegistrationArtistMapper;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationArtistDTO.SubBankAccountITDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.BankAccountIT;
import org.springframework.stereotype.Component;

@Component
public class SubBankAccountITMapper {

    public static BankAccountIT SubBankAccountITDTOToBankAccountIT (SubBankAccountITDTO subBankAccountITDTO) {
        if (subBankAccountITDTO == null) {
            return null;
        }

        BankAccountIT bankAccountIT = new BankAccountIT();

        bankAccountIT.setBeneficiaryName(subBankAccountITDTO.getBeneficiaryName());
        bankAccountIT.setBankName(subBankAccountITDTO.getBankName());
        bankAccountIT.setAbi(subBankAccountITDTO.getAbi());
        bankAccountIT.setCab(subBankAccountITDTO.getCab());
        bankAccountIT.setIban(subBankAccountITDTO.getIban());

        return bankAccountIT;
    }

    public static SubBankAccountITDTO bankAccountITToSubBankAccountITDTO (BankAccountIT bankAccountIT) {
        if (bankAccountIT == null) {
            return null;
        }

        SubBankAccountITDTO subBankAccountITDTO = new SubBankAccountITDTO();

        subBankAccountITDTO.setBeneficiaryName(bankAccountIT.getBeneficiaryName());
        subBankAccountITDTO.setBankName(bankAccountIT.getBankName());
        subBankAccountITDTO.setAbi(bankAccountIT.getAbi());
        subBankAccountITDTO.setCab(bankAccountIT.getCab());
        subBankAccountITDTO.setIban(bankAccountIT.getIban());

        return subBankAccountITDTO;
    }

}
