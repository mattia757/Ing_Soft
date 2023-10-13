package ing_soft.bonfiglio.scozzari.Ing_Soft;

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
