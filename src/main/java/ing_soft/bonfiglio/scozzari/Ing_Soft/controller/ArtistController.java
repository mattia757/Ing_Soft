package ing_soft.bonfiglio.scozzari.Ing_Soft.controller;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.InputDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.RegistrationArtistMapper;
import ing_soft.bonfiglio.scozzari.Ing_Soft.service.implementation.ArtistServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/artist")
public class ArtistController {

    private ArtistServiceImpl artistService;
    private RegistrationArtistMapper registrationArtistMapper;
    @PostMapping(value = "/add")
    private ResponseEntity<String> create(
            @RequestBody InputDTO registrationArtistDTO
    ){
        try {
            artistService.addArtist(registrationArtistMapper.getArtistFromDTO(registrationArtistDTO));
            return ResponseEntity.status(HttpStatus.CREATED).body("Artist successfully created!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
