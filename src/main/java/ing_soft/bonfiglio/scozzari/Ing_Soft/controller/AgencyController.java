package ing_soft.bonfiglio.scozzari.Ing_Soft.controller;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.AgencyDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.InputDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.AgencyMapper;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Agency;
import ing_soft.bonfiglio.scozzari.Ing_Soft.service.implementation.AgencyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/agency")
public class AgencyController {

    @Autowired
    private AgencyServiceImpl agencyService;
    @Autowired
    private AgencyMapper agencyMapper;

    @PostMapping(value = "/add")
    private ResponseEntity<String> create(
            @RequestBody InputDTO agencyDTO
    ){
        try {
            agencyService.addAgency(agencyMapper.agencyDTOToAgency(agencyDTO));
            return ResponseEntity.status(HttpStatus.CREATED).body("Agency successfully created!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping(value = "/linkAgencyArtists")
    private ResponseEntity<String> linkAgencyArtists(
            @RequestBody Long idAgency,
            @RequestBody Set<Long> idArtists
    ) {
        try {
            agencyService.linkAgencyArtist(idAgency, idArtists);
            return ResponseEntity.status(HttpStatus.CREATED).body("Agency and Artists successfully linked!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
