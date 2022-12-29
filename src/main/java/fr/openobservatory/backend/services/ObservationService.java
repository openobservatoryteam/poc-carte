package fr.openobservatory.backend.services;

import fr.openobservatory.backend.dtos.ObservationDTO;
import fr.openobservatory.backend.entities.ObservationEntity;
import fr.openobservatory.backend.repositories.ObservationRepository;
import fr.openobservatory.backend.transformators.GenericTransformator;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ObservationService {

  private final ObservationRepository observationRepository;
  private final GenericTransformator<ObservationEntity, ObservationDTO> observationTransformator;

  private final Double LOCATION_PRECISION = 1.0;

  public List<ObservationDTO> getNearbyObservations(Double latitude, Double longitude) {
    System.out.println("---");
    System.out.println(latitude - LOCATION_PRECISION);
    System.out.println(latitude + LOCATION_PRECISION);
    System.out.println(observationRepository.findAll().iterator().next().latitude());
    System.out.println("---");
    return observationTransformator.modelsToDtos(
        observationRepository.findAllByLatitudeBetweenAndLongitudeBetween(
            latitude - LOCATION_PRECISION, latitude + LOCATION_PRECISION,
            longitude - LOCATION_PRECISION, longitude + LOCATION_PRECISION),
        ObservationDTO.class);
  }
}
