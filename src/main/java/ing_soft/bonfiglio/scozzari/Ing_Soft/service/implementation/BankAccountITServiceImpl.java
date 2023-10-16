package ing_soft.bonfiglio.scozzari.Ing_Soft.service.implementation;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.BankAccountIT;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.interfaces.BankAccount;
import ing_soft.bonfiglio.scozzari.Ing_Soft.repo.BankAccountITRepository;
import ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces.BankAccountITService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class BankAccountITServiceImpl implements BankAccountITService {

    private final BankAccountITRepository bankAccountITRepository;

    @Override
    public BankAccountIT addBankAccountIT(BankAccountIT bankAccountIT) throws Exception {
        //if(bankAccountITRepository.findById(bankAccountIT.getId()).isEmpty()){
            bankAccountITRepository.save(bankAccountIT);
        //} else {
            //throw new Exception("exception");
        //}
        return bankAccountIT;
    }
}
