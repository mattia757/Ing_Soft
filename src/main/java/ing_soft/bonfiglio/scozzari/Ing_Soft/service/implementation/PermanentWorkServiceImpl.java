package ing_soft.bonfiglio.scozzari.Ing_Soft.service.implementation;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.PermanentWork;
import ing_soft.bonfiglio.scozzari.Ing_Soft.repo.PermanentWorkRepository;
import ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces.PermanentWorkService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class PermanentWorkServiceImpl implements PermanentWorkService {

    private final PermanentWorkRepository permanentWorkRepository;
    @Override
    public PermanentWork addPermanentWork(PermanentWork permanentWork) throws Exception{
        //if(permanentWorkRepository.findById(permanentWork.getId()).isEmpty()){
            permanentWorkRepository.save(permanentWork);
        //} else {
            //throw new Exception("exception");
        //}
        return permanentWork;
    }
}
