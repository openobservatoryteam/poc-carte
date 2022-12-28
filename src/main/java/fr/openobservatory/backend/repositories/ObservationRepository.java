package fr.openobservatory.backend.repositories;

import fr.openobservatory.backend.entities.ObservationEntity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ObservationRepository extends CrudRepository<ObservationEntity, Integer> {

  List<ObservationEntity> findAllByLatitudeBetweenAndLongitudeBetween(
      Double minLatitude, Double maxLatitude, Double minLongitude, Double maxLongitude);
}
