package fr.openobservatory.backend.dtos;

import fr.openobservatory.backend.entities.ObservationEntity;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public record ObservationDTO(
    Integer id,
    String description,
    ObservatoryLocationView location,
    Integer orientation,
    CelestialBodyDTO celestialBody,
    UserDTO author,
    OffsetDateTime createdAt) {

  public static ObservationDTO from(ObservationEntity observation) {
    return new ObservationDTO(
        observation.getId(),
        observation.getDescription(),
        new ObservatoryLocationView(observation.getLatitude(), observation.getLongitude()),
        observation.getOrientation(),
        CelestialBodyDTO.from(observation.getCelestialBody()),
        UserDTO.from(observation.getAuthor()),
        observation.getCreatedAt().atOffset(ZoneOffset.UTC));
  }

  private record ObservatoryLocationView(Double latitude, Double longitude) {}
}
