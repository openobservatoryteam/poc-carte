package fr.openobservatory.backend.model.observation;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface ObservationRepository extends CrudRepository<ObservationEntity, UUID> {

    List<ObservationEntity> findAllByLatitudeBetweenAndLongitudeBetween(
            Double minLatitude, Double maxLatitude, Double minLongitude, Double maxLongitude);
}
