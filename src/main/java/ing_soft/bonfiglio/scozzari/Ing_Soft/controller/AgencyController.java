package ing_soft.bonfiglio.scozzari.Ing_Soft.controller;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.AgencyDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.InputDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.AgencyMapper;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Agency;
import ing_soft.bonfiglio.scozzari.Ing_Soft.service.implementation.AgencyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
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

    @PutMapping(value = "/update/{idAgency}")
    private ResponseEntity<String> update(
            @RequestBody InputDTO agencyDTO,
            @PathVariable Long idAgency
    ){
        try {
            System.out.println(idAgency);
            agencyService.updateAgency(agencyMapper.agencyDTOToAgency(agencyDTO), idAgency);
            return ResponseEntity.status(HttpStatus.OK).body("Agency successfully updated!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping(value = "/delete/{idAgency}")
    private ResponseEntity<String> delete(
            @PathVariable Long idAgency
    ){
        try {
            agencyService.deleteAgency(idAgency);
            return ResponseEntity.status(HttpStatus.OK).body("Agency successfully deleted!");
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
