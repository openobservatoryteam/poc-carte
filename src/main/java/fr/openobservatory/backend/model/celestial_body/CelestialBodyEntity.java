package fr.openobservatory.backend.model.celestial_body;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class CelestialBodyEntity {

    @Id
    private UUID id;

    @Column
    private String name;

    // ---

    public static CelestialBodyEntity create(String name) {
        var celestialBody = new CelestialBodyEntity();
        celestialBody.setId(UUID.randomUUID());
        celestialBody.setName(name);
        return celestialBody;
    }
}
