package ing_soft.bonfiglio.scozzari.Ing_Soft.service.implementation;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Retired;
import ing_soft.bonfiglio.scozzari.Ing_Soft.repo.RetiredRepository;
import ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces.RetiredService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class RetiredServiceImpl implements RetiredService {

    private final RetiredRepository retiredRepository;

    @Override
    public Retired addRetired(Retired retired) throws Exception{
        //if(retiredRepository.findById(retired.getId()).isEmpty()){
            retiredRepository.save(retired);
        //} else {
            //throw new Exception("exception");
        //}
        return retired;
    }
}
