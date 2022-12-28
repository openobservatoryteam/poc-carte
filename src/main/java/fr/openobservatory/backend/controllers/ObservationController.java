package fr.openobservatory.backend.controllers;

import fr.openobservatory.backend.dtos.ObservationDTO;
import fr.openobservatory.backend.repositories.ObservationRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/observations")
public class ObservationController {

  private final ObservationRepository observationRepository;

  @GetMapping("/nearby")
  public List<ObservationDTO> findAllNearbyAction(
      @RequestParam Double latitude, @RequestParam Double longitude) {
    return observationRepository
        .findAllByLatitudeBetweenAndLongitudeBetween(
            latitude - 0.03, latitude + 0.03,
            longitude - 0.03, longitude + 0.03)
        .stream()
        .map(ObservationDTO::from)
        .toList();
  }
}
