package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.InputDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.TheaterDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Theater;
import org.springframework.stereotype.Component;

@Component
public class TheaterMapper {

    public TheaterDTO theaterToTheaterDTO(Theater theater) {
        if ( theater == null ) {
            return null;
        }

        TheaterDTO theaterDTO = new TheaterDTO();

        theaterDTO.setName( theater.getName() );
        theaterDTO.setCity( theater.getCity() );
        theaterDTO.setTel( theater.getTel() );
        theaterDTO.setEmail( theater.getEmail() );
        theaterDTO.setPec( theater.getPec() );
        theaterDTO.setTaxCode( theater.getTaxCode() );
        theaterDTO.setRecipientCode( theater.getRecipientCode() );
        theaterDTO.setUniqueCode( theater.getUniqueCode() );

        return theaterDTO;
    }

    public Theater theaterDTOToTheater(InputDTO dto) {

        if (dto instanceof TheaterDTO theaterdto) {
            Theater theater = new Theater();

            theater.setName( theaterdto.getName() );
            theater.setCity( theaterdto.getCity() );
            theater.setTel( theaterdto.getTel() );
            theater.setEmail( theaterdto.getEmail() );
            theater.setIva( theaterdto.getIva() );
            theater.setPec( theaterdto.getPec() );
            theater.setTaxCode( theaterdto.getTaxCode() );
            theater.setUniqueCode( theaterdto.getUniqueCode() );
            theater.setRecipientCode( theaterdto.getRecipientCode() );

            return theater;
        }else
            throw new ClassCastException("Il DTO fornito non è un TheaterDTO");
    }

}