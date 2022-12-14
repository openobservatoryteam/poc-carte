package fr.openobservatory.backend.model.celestial_body;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CelestialBodyRepository extends CrudRepository<CelestialBodyEntity, UUID> {
}
