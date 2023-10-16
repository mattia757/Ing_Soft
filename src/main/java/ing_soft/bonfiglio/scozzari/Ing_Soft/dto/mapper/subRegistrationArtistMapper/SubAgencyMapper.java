package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.subRegistrationArtistMapper;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.InputDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationArtistDTO.SubAgencyDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Agency;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class SubAgencyMapper {

//    public static Agency agencyDTOToAgency(SubAgencyDTO subAgencyDTO) {
//        if (subAgencyDTO == null) {
//            return null;
//        } else {
//            Agency agency = new Agency();
//
//            Set<Agency> agencies = subAgencyDTO.getIdAgency().stream()
//                    .map(id -> {
//                        Agency subAgency = new Agency();
//                        subAgency.setId(id);
//                        return subAgency;
//                    })
//                    .collect(Collectors.toSet());
//
//            agency.setId(agencies);
//
//            return agency;
//        }
//    }
//
//    public static SubAgencyDTO agencyToAgencyDTO (Agency agency) {
//        if (agency == null) {
//            return null;
//        }
//        else {
//            SubAgencyDTO subAgencyDTO = new SubAgencyDTO();
//
//            subAgencyDTO.setAgencyName(agency.getName());
//            subAgencyDTO.setAgencyEmail(agency.getEmail());
//            subAgencyDTO.setAgencyPhone1(agency.getTel1());
//            subAgencyDTO.setAgencyPhone2(agency.getTel2());
//            subAgencyDTO.setWebsite(agency.getWebSite());
//
//            return subAgencyDTO;
//        }
//    }
}