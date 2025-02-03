package it.immobiliare.immobile.controller;

import it.immobiliare.immobile.dto.ImmobileDTO;
import it.immobiliare.immobile.service.ImmobileService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class ImmobileController {

    @Autowired
    private ImmobileService immobileService;

    @GetMapping("/hello")
    public ResponseEntity<String> getHello(){

        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    @GetMapping("/immobili")
    public ResponseEntity<List<ImmobileDTO>> getImmobili() {

        /* Usato inizialmente per test api
        List<ImmobileDTO> immobileList = new ArrayList<>();
        ImmobileDTO immobile = new ImmobileDTO();
        immobile.setId(11111L);
        immobile.setShortDescription("appartamento 1");
        immobile.setCity("Napoli");
        immobileList.add(immobile);
        ImmobileDTO immobile2 = new ImmobileDTO();
        immobile2.setId(22222L);
        immobile2.setShortDescription("appartamento 2");
        immobile2.setCity("Caserta");
        immobileList.add(immobile2);
        */

        List<ImmobileDTO> immobileDTOList = immobileService.getImmobili();
        return new ResponseEntity<>(immobileDTOList, HttpStatus.OK);
    }

    @PostMapping("/immobili")
    public ResponseEntity<ImmobileDTO> saveImmobile(@RequestBody ImmobileDTO immobileDTO) {

        log.debug("Creazione nuovo immobile con gli attributi:");
        log.debug("=> ShortDescription: {}", immobileDTO.getShortDescription());
        log.debug("=> Description: {}", immobileDTO.getDescription());
        log.debug("=> City: {}", immobileDTO.getCity());

        immobileDTO = immobileService.saveImmobile(immobileDTO);
        return new ResponseEntity<>(immobileDTO, HttpStatus.CREATED);
    }

    @GetMapping("/immobili/{immobileId}")
    public ResponseEntity<ImmobileDTO> getImmobile( @PathVariable Long immobileId) {

        log.debug("Recuperato immobile con immobileId: {}", immobileId);
        /* per test senza service
        ImmobileDTO immobile = new ImmobileDTO();
        immobile.setId(11111L);
        immobile.setShortDescription("appartamento 1");
        immobile.setCity("Napoli");
         */

        ImmobileDTO immobileDTO = immobileService.getImmobile(immobileId);
        if (immobileDTO != null) {
            return new ResponseEntity<>(immobileDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/immobili/{immobileId}")
    public ResponseEntity<ImmobileDTO> deleteImmobile( @PathVariable Long immobileId) {

        log.debug("Cancellato immobile con immobileId: {}", immobileId);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

}
