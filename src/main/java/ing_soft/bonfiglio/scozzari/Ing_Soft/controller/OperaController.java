package ing_soft.bonfiglio.scozzari.Ing_Soft.controller;

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
            @RequestBody OperaDTO operaDTO
    ){
        try {
            operaService.addOpera(operaDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Opera successfully created!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
