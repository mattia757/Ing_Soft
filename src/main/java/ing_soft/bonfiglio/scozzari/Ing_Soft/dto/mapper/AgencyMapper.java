package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.AgencyDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Agency;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
public class AgencyMapper {

    public AgencyDTO agencyToAgencyDTO(Agency agency) {
        if ( agency == null ) {
            return null;
        }

        AgencyDTO agencyDTO = new AgencyDTO();

        agencyDTO.setIdArtist( agency.getId() );
        agencyDTO.setIdUser( agency.getId() );
        agencyDTO.setName( agency.getName() );
        agencyDTO.setEmail( agency.getEmail() );
        agencyDTO.setPec( agency.getPec() );
        agencyDTO.setTel1( agency.getTel1() );
        agencyDTO.setTel2( agency.getTel2() );

        return agencyDTO;
    }

    public Agency agencyDTOToAgency(AgencyDTO agencydto) {
        if ( agencydto == null ) {
            return null;
        }

        Agency agency = new Agency();

        agency.setId( agencydto.getIdArtist() );
        agency.setName( agencydto.getName() );
        agency.setEmail( agencydto.getEmail() );
        agency.setPec( agencydto.getPec() );
        agency.setTel1( agencydto.getTel1() );
        agency.setTel2( agencydto.getTel2() );

        return agency;
    }
}
