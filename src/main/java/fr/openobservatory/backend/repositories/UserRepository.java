package fr.openobservatory.backend.repositories;

import fr.openobservatory.backend.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {}
