package ing_soft.bonfiglio.scozzari.Ing_Soft.controller;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.InputDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.TheaterDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.TheaterMapper;
import ing_soft.bonfiglio.scozzari.Ing_Soft.service.implementation.TheaterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/theater")
public class TheaterController {

    @Autowired
    private TheaterServiceImpl theaterService;
    @Autowired
    private TheaterMapper theaterMapper;

    @PostMapping(value = "/add")
    private ResponseEntity<String> create (
        @RequestBody InputDTO theaterDTO
    ){
        try {
            System.out.println(theaterDTO.toString());
            theaterService.addTheater(theaterMapper.theaterDTOToTheater(theaterDTO));
            return ResponseEntity.status(HttpStatus.CREATED).body("Theater successfully created!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping(value = "/addArtistsToOpera")
    private ResponseEntity<String> addArtistsToOpera (
        @RequestBody Set<Long> idArtists,
        @RequestBody Long idOpera,
        @RequestBody Long idTheater,
        @RequestBody Long idSeason
    ) {
        try {
            theaterService.addArtistsToOpera(idTheater, idSeason, idOpera, idArtists);
            return ResponseEntity.status(HttpStatus.CREATED).body("Artists successfully added to opera!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
