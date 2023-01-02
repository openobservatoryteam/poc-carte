package fr.openobservatory.backend.entities;

import jakarta.persistence.*;
import java.time.Instant;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;

@Data
@Entity
@Accessors(chain = true)
public class ObservationEntity {

  @Id @GeneratedValue private Integer id;

  @Column private String description;

  @Column private Double latitude;

  @Column private Double longitude;

  @Column private Integer orientation;

  @ManyToOne private CelestialBodyEntity celestialBody;

  @ManyToOne private UserEntity author;

  @CreationTimestamp private Instant createdAt;
}
