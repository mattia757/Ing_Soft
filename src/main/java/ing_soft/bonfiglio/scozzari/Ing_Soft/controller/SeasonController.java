package ing_soft.bonfiglio.scozzari.Ing_Soft.controller;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.SeasonDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.SeasonMapper;
import ing_soft.bonfiglio.scozzari.Ing_Soft.service.implementation.SeasonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/season")
public class SeasonController {
    @Autowired
    private SeasonMapper seasonMapper;
    @Autowired
    private SeasonServiceImpl seasonService;

    @PostMapping(value = "/add")
    private ResponseEntity<String> create(
            @RequestBody SeasonDTO seasonDTO
    ){
        try {
            System.out.println(seasonDTO.getIdTheater());
            seasonService.addSeason(seasonDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Season successfully created!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
