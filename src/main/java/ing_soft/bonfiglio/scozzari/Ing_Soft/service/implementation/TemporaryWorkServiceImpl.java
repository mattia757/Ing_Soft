package ing_soft.bonfiglio.scozzari.Ing_Soft.service.implementation;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.TemporaryWork;
import ing_soft.bonfiglio.scozzari.Ing_Soft.repo.TemporaryWorkRepository;
import ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces.TemporaryWorkService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class TemporaryWorkServiceImpl implements TemporaryWorkService {

    private final TemporaryWorkRepository temporaryWorkRepository;

    @Override
    public TemporaryWork addTemporaryWork(TemporaryWork temporaryWork) throws Exception {
        //if(temporaryWorkRepository.findById(temporaryWork.getId()).isEmpty()){
            temporaryWorkRepository.save(temporaryWork);
        //} else {
            //throw new Exception("exception");
        //}
        return temporaryWork;
    }
}
