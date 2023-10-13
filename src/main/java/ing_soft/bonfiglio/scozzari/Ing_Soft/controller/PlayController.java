package ing_soft.bonfiglio.scozzari.Ing_Soft.controller;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.PlayDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.PlayMapper;
import ing_soft.bonfiglio.scozzari.Ing_Soft.service.implementation.PlayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/play")
public class PlayController {

    @Autowired
    private PlayServiceImpl playService;
    @Autowired
    private PlayMapper playMapper;

    @PostMapping(value = "/add")
    private ResponseEntity<String> create(
            @RequestBody PlayDTO playDTO
            ){
        try {
            playService.addPlay(playDTO);
            return ResponseEntity.ok("Play successfully created!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
