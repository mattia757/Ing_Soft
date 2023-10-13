package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper;

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


    public static Opera operaDTOToOpera(OperaDTO operaDTO) {
        Opera opera = new Opera();

        opera.setTitle(operaDTO.getTitle());
        opera.setStartDate(operaDTO.getStartDate());
        opera.setStartRehearsal(operaDTO.getStartRehearsal());

        return opera;
    }
}
