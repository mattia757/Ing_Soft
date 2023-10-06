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

    public OperaDTO operaToOperaDTO(Opera opera) {
        if ( opera == null ) {
            return null;
        }

        OperaDTO operaDTO = new OperaDTO();

        operaDTO.setIdVenue( opera.getId() );
        operaDTO.setSeasonId( opera.getId() );
        operaDTO.setTitle( opera.getTitle() );
        if ( opera.getStartDate() != null ) {
            operaDTO.setStartDate( LocalDateTime.ofInstant( opera.getStartDate().toInstant(), ZoneOffset.UTC ).toLocalDate() );
        }
        if ( opera.getStartRehearsal() != null ) {
            operaDTO.setStartRehearsal( LocalDateTime.ofInstant( opera.getStartRehearsal().toInstant(), ZoneOffset.UTC ).toLocalDate() );
        }

        return operaDTO;
    }

    public Opera operaDTOToOpera(OperaDTO operaDTO) {
        if ( operaDTO == null ) {
            return null;
        }

        Opera opera = new Opera();

        opera.setId( operaDTO.getIdVenue() );
        opera.setTitle( operaDTO.getTitle() );
        if ( operaDTO.getStartDate() != null ) {
            opera.setStartDate( Date.from( operaDTO.getStartDate().atStartOfDay( ZoneOffset.UTC ).toInstant() ) );
        }
        opera.setIdVenue( operaDTO.getIdVenue() );
        if ( operaDTO.getStartRehearsal() != null ) {
            opera.setStartRehearsal( Date.from( operaDTO.getStartRehearsal().atStartOfDay( ZoneOffset.UTC ).toInstant() ) );
        }

        return opera;
    }
}
