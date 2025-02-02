package it.immobiliare.immobile.controller;

import it.immobiliare.immobile.dto.ImmobileDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class ImmobileController {

    @GetMapping("/hello")
    public ResponseEntity<String> getHello(){

        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    @GetMapping("/immobili")
    public ResponseEntity<List<ImmobileDTO>> getImmobili() {

        List<ImmobileDTO> immobileList = new ArrayList<ImmobileDTO>();
        //ImmobileDTO immobile = new ImmobileDTO();
        //immobileList.add(immobile);

        return new ResponseEntity<>(immobileList, HttpStatus.OK);
    }

    @GetMapping("/immobili/{immobileId}")
    public ResponseEntity<List<ImmobileDTO>> getImmobile( @PathVariable Long immobileId) {

        log.debug("Recuperato immobile con immobileId: {}", immobileId);
        List<ImmobileDTO> immobileList = new ArrayList<ImmobileDTO>();
        ImmobileDTO immobile = new ImmobileDTO();
        immobileList.add(immobile);

        return new ResponseEntity<>(immobileList, HttpStatus.OK);
    }

    @DeleteMapping("/immobili/{immobileId}")
    public ResponseEntity<List<ImmobileDTO>> deleteImmobile( @PathVariable Long immobileId) {

        log.debug("Cancellato immobile con immobileId: {}", immobileId);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

}
