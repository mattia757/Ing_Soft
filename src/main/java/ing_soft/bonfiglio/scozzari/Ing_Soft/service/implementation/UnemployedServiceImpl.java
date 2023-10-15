package ing_soft.bonfiglio.scozzari.Ing_Soft.service.implementation;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Unemployed;
import ing_soft.bonfiglio.scozzari.Ing_Soft.repo.UnemployedRepository;
import ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces.UnemployedService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class UnemployedServiceImpl implements UnemployedService {

    private final UnemployedRepository unemployedRepository;
    @Override
    public void addUnemployed(Unemployed unemployed) throws Exception {
        if(unemployedRepository.findById(unemployed.getId()).isEmpty()){
            unemployedRepository.save(unemployed);
        } else {
            throw new Exception("exception");
        }
    }
}
