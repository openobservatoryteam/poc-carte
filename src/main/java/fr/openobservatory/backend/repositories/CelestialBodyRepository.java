package fr.openobservatory.backend.repositories;

import fr.openobservatory.backend.entities.CelestialBodyEntity;
import org.springframework.data.repository.CrudRepository;

public interface CelestialBodyRepository extends CrudRepository<CelestialBodyEntity, Integer> {}
