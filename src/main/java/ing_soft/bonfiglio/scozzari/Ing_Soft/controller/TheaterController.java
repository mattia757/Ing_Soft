package ing_soft.bonfiglio.scozzari.Ing_Soft.controller;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.InputDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.TheaterDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.TheaterMapper;
import ing_soft.bonfiglio.scozzari.Ing_Soft.service.implementation.TheaterServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/theater")
public class TheaterController {

    private TheaterServiceImpl theaterService;
    private TheaterMapper theaterMapper;

    @PostMapping(value = "/add")
    private ResponseEntity<String> create (
        @RequestBody InputDTO theaterDTO
    ){
        try {
            theaterService.addTheater(theaterMapper.theaterDTOToTheater((TheaterDTO) theaterDTO));
            return ResponseEntity.status(HttpStatus.CREATED).body("Theater successfully created!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
