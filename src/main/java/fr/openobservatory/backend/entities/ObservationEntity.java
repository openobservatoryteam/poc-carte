package fr.openobservatory.backend.entities;

import jakarta.persistence.*;
import java.time.Instant;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

@Data
@Entity
public class ObservationEntity {

  @Id @GeneratedValue private Integer id;

  @Column private String description;

  @Column private Double latitude;

  @Column private Double longitude;

  @Column private Integer orientation;

  @ManyToOne private CelestialBodyEntity celestialBody;

  @ManyToOne private UserEntity author;

  @CreationTimestamp private Instant createdAt;

  public static ObservationEntity create(
      Double latitude,
      Double longitude,
      Integer orientation,
      CelestialBodyEntity celestialBody,
      UserEntity author,
      String description) {
    var observation = new ObservationEntity();
    observation.setLatitude(latitude);
    observation.setLongitude(longitude);
    observation.setOrientation(orientation);
    observation.setCelestialBody(celestialBody);
    observation.setAuthor(author);
    observation.setDescription(description);
    observation.setCreatedAt(Instant.now());
    return observation;
  }
}
