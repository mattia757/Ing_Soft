package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.subRegistrationAgencyMapper;


import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.InputDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationAgencyDTO.SubUserAgencyDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Agency;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.User;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.enums.AgencyRoles;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.middleTables.UserAgency;
import org.springframework.stereotype.Component;

@Component
public class SubUserAgencyMapper {

        public static SubUserAgencyDTO userAgencyToSubUserAgencyDTO(InputDTO userDTO, InputDTO agencyDTO) {

            if ( userDTO instanceof SubUserAgencyDTO && agencyDTO instanceof SubUserAgencyDTO) {
                SubUserAgencyDTO subUserAgencyDTO = new SubUserAgencyDTO();
                UserAgency userAgency = new UserAgency();

                subUserAgencyDTO.setIdUser(userAgency.getUser().getId());
                subUserAgencyDTO.setIdAgency(userAgency.getAgency().getId());
                subUserAgencyDTO.setRole(userAgency.getRole().toString());

                return subUserAgencyDTO;
            } else {

                return null;
            }
        }

        public static UserAgency subUserAgencyDTOToUserAgency(InputDTO userDTO, InputDTO agencyDTO) {

            if ( userDTO instanceof SubUserAgencyDTO && agencyDTO instanceof SubUserAgencyDTO) {
                SubUserAgencyDTO subUserAgencyDTO = new SubUserAgencyDTO();
                UserAgency userAgency = new UserAgency();

                userAgency.setRole(AgencyRoles.valueOf(subUserAgencyDTO.getRole()));

                User user = new User();
                user.setId(subUserAgencyDTO.getIdUser());
                userAgency.setUser(user);

                Agency agency = new Agency();
                agency.setId(subUserAgencyDTO.getIdAgency());
                userAgency.setAgency(agency);

                return userAgency;
            } else {

                return null;
            }
        }

}
