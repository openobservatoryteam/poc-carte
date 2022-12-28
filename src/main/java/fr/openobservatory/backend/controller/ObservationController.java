package fr.openobservatory.backend.controller;

import fr.openobservatory.backend.model.observation.ObservationRepository;
import fr.openobservatory.backend.view.ObservationView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/observations")
public class ObservationController {

    private final ObservationRepository observationRepository;

    @GetMapping("/nearby")
    public List<ObservationView> findAllNearby(@RequestParam Double latitude, @RequestParam Double longitude) {
        return observationRepository.findAllByLatitudeBetweenAndLongitudeBetween(
                        latitude - 0.03, latitude + 0.03,
                        longitude - 0.03, longitude + 0.03)
                .stream()
                .map(ObservationView::from)
                .toList();
    }
}
