package ing_soft.bonfiglio.scozzari.Ing_Soft.controller;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.InputDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.VenueDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.VenueMapper;
import ing_soft.bonfiglio.scozzari.Ing_Soft.service.implementation.VenueServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/venue")
public class VenueController{

    @Autowired
    private VenueServiceImpl venueService;
    @Autowired
    private VenueMapper venueMapper;

    @PostMapping(value = "/add")
    private ResponseEntity<String> create(
            @RequestBody InputDTO venueDTO
    ){
        try {
            if (venueDTO instanceof VenueDTO) {
                venueService.addVenue(venueMapper.venueDTOToVenue(venueDTO), ((VenueDTO) venueDTO).getIdTheater());
            }

            return ResponseEntity.status(HttpStatus.CREATED).body("Venue successfully created!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
