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

import java.util.List;

@RestController
@RequestMapping("/api/agency")
public class AgencyController {

    @Autowired
    private AgencyServiceImpl agencyService;
    @Autowired
    private AgencyMapper agencyMapper;

    @PostMapping(value = "/add")
    private ResponseEntity<String> create(
            @RequestBody AgencyDTO agencyDTO
    ){
        try {
            agencyService.addAgency(agencyDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Agency successfully created!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping(value = "/delete")
    private ResponseEntity<String> delete(
            @RequestBody String agencyName
    ){
        try {
            agencyService.deleteAgency(agencyName);
            return ResponseEntity.status(HttpStatus.OK).body("Agency successfully deleted!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping(value = "/update/{agencyName}")
    private ResponseEntity<String> update(
            @RequestBody AgencyDTO agencyDTO,
            @PathVariable String agencyName
    ){
        try {
            System.out.println(agencyDTO.getAgencyName() + " " + agencyName);
            agencyService.updateAgency(agencyDTO, agencyName);
            return ResponseEntity.status(HttpStatus.OK).body("Agency successfully updated!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(value = "/getAgencyByName")
    private ResponseEntity<AgencyDTO> getAgencyByName(
            @RequestParam String agencyName
    ){
        try {
            Agency agency = agencyService.getAgencyByName(agencyName);
            AgencyDTO agencyDTO = agencyMapper.agencyToAgencyDTO(agency);
            return ResponseEntity.status(HttpStatus.OK).body(agencyDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(value = "/getAgencies")
    private ResponseEntity<String> getAgencies(){
        try {
            List<Agency> agencies = agencyService.getAgencies();
            return ResponseEntity.status(HttpStatus.OK).body(agencies.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
