package fr.openobservatory.backend.utils;

import fr.openobservatory.backend.entities.CelestialBodyEntity;
import fr.openobservatory.backend.entities.ObservationEntity;
import fr.openobservatory.backend.entities.UserEntity;
import fr.openobservatory.backend.repositories.CelestialBodyRepository;
import fr.openobservatory.backend.repositories.ObservationRepository;
import fr.openobservatory.backend.repositories.UserRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DatabaseFiller {

  private final CelestialBodyRepository celestialBodyRepository;
  private final ObservationRepository observationRepository;
  private final UserRepository userRepository;

  @Bean
  public CommandLineRunner fillDatabase() {
    var users =
        List.of(
            new UserEntity("biojokev"),
            new UserEntity("hamelth1"),
            new UserEntity("fickeluc"),
            new UserEntity("karakber"),
            new UserEntity("heberrom"),
            new UserEntity("marybtho"));
    var bodies =
        List.of(
            CelestialBodyEntity.create("Mars"),
            CelestialBodyEntity.create("Mercure"),
            CelestialBodyEntity.create("Neptune"),
            CelestialBodyEntity.create("Soleil"));
    var observations =
        List.of(
            ObservationEntity.create(
                49.441750062818144, 1.090743186110451, 0, bodies.get(3), users.get(0), null),
            ObservationEntity.create(
                49.43089503379546,
                1.0839555895177384,
                90,
                bodies.get(2),
                users.get(2),
                "Whaou j'ai vu Neptune"),
            ObservationEntity.create(
                49.447273149114366,
                1.0924529935376541,
                15,
                bodies.get(0),
                users.get(1),
                "Une sacrée vue sur Mars !"),
            ObservationEntity.create(
                49.43851868471619,
                1.110829923383208,
                78,
                bodies.get(1),
                users.get(5),
                "Mercure, c'est beau"),
            ObservationEntity.create(
                49.386955811932225,
                1.0693351828124036,
                44,
                bodies.get(3),
                users.get(3),
                "Le Soleil vu en cours"),
            ObservationEntity.create(
                49.29345564180719, 1.0042352782499628, 160, bodies.get(2), users.get(4), null));
    return args -> {
      userRepository.saveAll(users);
      celestialBodyRepository.saveAll(bodies);
      observationRepository.saveAll(observations);
    };
  }
}
