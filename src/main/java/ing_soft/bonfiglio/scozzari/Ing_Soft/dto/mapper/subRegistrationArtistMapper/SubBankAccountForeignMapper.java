package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.subRegistrationArtistMapper;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationArtistDTO.SubBankAccountForeignDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.BankAccountForeign;
import org.springframework.stereotype.Component;

@Component
public class SubBankAccountForeignMapper {

    public static BankAccountForeign subBankAccountForeignDTOToBankAccountForeign (SubBankAccountForeignDTO subBankAccountForeignDTO) {
        if (subBankAccountForeignDTO == null) {
            return null;
        }

        BankAccountForeign bankAccountForeign = new BankAccountForeign();

        bankAccountForeign.setBeneficiaryName(subBankAccountForeignDTO.getBeneficiaryName());
        bankAccountForeign.setIban(subBankAccountForeignDTO.getIban());
        bankAccountForeign.setBicSwift(subBankAccountForeignDTO.getBicSwift());

        return bankAccountForeign;
    }

    public static SubBankAccountForeignDTO bankAccountForeignToSubBankAccountForeignDTO (BankAccountForeign bankAccountForeign) {
        if (bankAccountForeign == null) {
            return null;
        }

        SubBankAccountForeignDTO subBankAccountForeignDTO = new SubBankAccountForeignDTO();

        subBankAccountForeignDTO.setBeneficiaryName(bankAccountForeign.getBeneficiaryName());
        subBankAccountForeignDTO.setIban(bankAccountForeign.getIban());
        subBankAccountForeignDTO.setBicSwift(bankAccountForeign.getBicSwift());

        return subBankAccountForeignDTO;
    }


}
