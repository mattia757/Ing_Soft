package ing_soft.bonfiglio.scozzari.Ing_Soft.service.implementation;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.BankAccountForeign;
import ing_soft.bonfiglio.scozzari.Ing_Soft.repo.BankAccountForeignRepository;
import ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces.BankAccountForeignService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class BankAccountForeignServiceImpl implements BankAccountForeignService {

    private final BankAccountForeignRepository bankAccountForeignRepository;

    @Override
    public BankAccountForeign addBankAccountForeign(BankAccountForeign bankAccountForeign) throws Exception {
        //if(bankAccountForeignRepository.findById(bankAccountForeign.getId()).isEmpty()){
            bankAccountForeignRepository.save(bankAccountForeign);
        //} else {
            //throw new Exception("exception");
        //}
        return bankAccountForeign;
    }
}
