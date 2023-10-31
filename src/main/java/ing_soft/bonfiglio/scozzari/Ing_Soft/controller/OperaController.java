package ing_soft.bonfiglio.scozzari.Ing_Soft.controller;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.InputDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.OperaArtistDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.OperaDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.OperaMapper;
import ing_soft.bonfiglio.scozzari.Ing_Soft.service.implementation.OperaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/opera")
public class OperaController {

    @Autowired
    private OperaServiceImpl operaService;
    @Autowired
    private OperaMapper operaMapper;

    @PostMapping(value = "/add")
    private ResponseEntity<String> create(
            @RequestBody InputDTO operaDTO
    ){
        try {
            if (operaDTO instanceof OperaDTO) {
                operaService.addOpera(operaMapper.operaDTOToOpera(operaDTO), ((OperaDTO) operaDTO).getIdVenue(), ((OperaDTO) operaDTO).getSeasonId());
            }

            return ResponseEntity.status(HttpStatus.CREATED).body("Opera successfully created!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

     @PostMapping(value = "/addArtists")
    private ResponseEntity<String> addArtists(
            @RequestBody InputDTO operaArtistsDTO
        ){
        try {
            if (operaArtistsDTO instanceof OperaArtistDTO dto) {
                System.out.println(operaArtistsDTO);
                operaService.addArtists(dto.getIdArtists(), dto.getIdOpera());
            }
            return ResponseEntity.status(HttpStatus.CREATED).body("Artists successfully added!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
     }
}
