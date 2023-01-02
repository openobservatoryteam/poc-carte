package fr.openobservatory.backend.controllers;

import fr.openobservatory.backend.dtos.ResponseDTO;
import fr.openobservatory.backend.services.ObservationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/observations")
public class ObservationController {

  private final ObservationService observationService;

  @GetMapping("/nearby")
  public ResponseEntity<ResponseDTO> findAllNearbyAction(
      @RequestParam Double latitude, @RequestParam Double longitude) {
    return ResponseEntity.ok(
        new ResponseDTO(observationService.getNearbyObservations(latitude, longitude)));
  }
}
