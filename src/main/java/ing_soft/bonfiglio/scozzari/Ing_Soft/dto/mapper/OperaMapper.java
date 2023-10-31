package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.InputDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.OperaDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Opera;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Component
public class OperaMapper {
    public Opera operaDTOToOpera(InputDTO operaDTO) {
        if (!(operaDTO instanceof OperaDTO operaData)){
            return null;
        }
        else {
            Opera opera = new Opera();

            opera.setTitle(operaData.getTitle());
            opera.setStartDate(operaData.getStartDate());
            opera.setStartRehearsal(operaData.getStartRehearsal());

            return opera;
        }
    }
}
