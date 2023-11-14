package ing_soft.bonfiglio.scozzari.Ing_Soft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "ing_soft.bonfiglio.scozzari.Ing_Soft.repo")
@EntityScan(basePackages = "ing_soft.bonfiglio.scozzari.Ing_Soft.model")
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
