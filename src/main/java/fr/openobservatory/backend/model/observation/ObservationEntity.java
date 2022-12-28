package fr.openobservatory.backend.model.observation;

import fr.openobservatory.backend.model.celestial_body.CelestialBodyEntity;
import fr.openobservatory.backend.model.user.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.UUID;

@Data
@Entity
public class ObservationEntity {

    @Id
    private UUID id;

    @Column
    private String description;

    @Column
    private Double latitude;

    @Column
    private Double longitude;

    @Column
    private Integer orientation;

    @ManyToOne
    private CelestialBodyEntity celestialBody;

    @ManyToOne
    private UserEntity author;

    @CreationTimestamp
    private Instant createdAt;

    // ---

    public static ObservationEntity create(Double latitude, Double longitude, Integer orientation, CelestialBodyEntity celestialBody, UserEntity author, String description) {
        var observation = new ObservationEntity();
        observation.setId(UUID.randomUUID());
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
