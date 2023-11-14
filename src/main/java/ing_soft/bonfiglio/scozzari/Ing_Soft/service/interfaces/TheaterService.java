package ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Theater;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface TheaterService {
    void addTheater(Theater theater) throws Exception;
    void updateTheater(Long id, Theater theater) throws Exception;

    void deleteTheater(Long id) throws Exception;
}
