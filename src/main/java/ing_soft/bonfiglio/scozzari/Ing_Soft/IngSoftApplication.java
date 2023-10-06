package ing_soft.bonfiglio.scozzari.Ing_Soft;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.AgencyDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.UserDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.AgencyMapper;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.UserMapper;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Agency;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IngSoftApplication {

	public static void main(String[] args) {

		SpringApplication.run(IngSoftApplication.class, args);

		//Test Mapper scritti a mano
		/*Agency agency = new Agency();

		AgencyMapper agencyMapper = new AgencyMapper();
		AgencyDTO agencyDTO = agencyMapper.agencyToAgencyDTO(agency);

		System.out.println(agencyDTO);*/

		/*Agency agency = new Agency();

		AgencyDTO agencyDTO = AgencyMapper.INSTANCE.agencyToAgencyDTO(agency);

		System.out.println(agencyDTO);*/
	}

}
