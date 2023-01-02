package fr.openobservatory.backend.dtos;

import java.time.OffsetDateTime;
import lombok.Data;

@Data
public class ObservationDTO {
  private Integer id;
  private String description;
  private Integer orientation;
  private CelestialBodyDTO celestialBody;
  private UserDTO author;
  private OffsetDateTime createdAt;
  private Double latitude;
  private Double longitude;
}
