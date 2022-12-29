package fr.openobservatory.backend.utils;

import fr.openobservatory.backend.entities.CelestialBodyEntity;
import fr.openobservatory.backend.entities.ObservationEntity;
import fr.openobservatory.backend.entities.UserEntity;
import fr.openobservatory.backend.repositories.CelestialBodyRepository;
import fr.openobservatory.backend.repositories.ObservationRepository;
import fr.openobservatory.backend.repositories.UserRepository;
import java.util.ArrayList;
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
            new CelestialBodyEntity("Mars"),
            new CelestialBodyEntity("Mercure"),
            new CelestialBodyEntity("Neptune"),
            new CelestialBodyEntity("Soleil"));
    var observations = new ArrayList<ObservationEntity>();
    var observation = new ObservationEntity();
    observations.add(
        observation
            .latitude(49.441750062818144)
            .longitude(1.090743186110451)
            .orientation(0)
            .celestialBody(bodies.get(3))
            .author(users.get(0)));
    observations.add(
        observation
            .latitude(49.43089503379546)
            .longitude(1.0839555895177384)
            .orientation(90)
            .celestialBody(bodies.get(2))
            .author(users.get(2))
            .description("Whaou j'ai vu Neptune"));
    observations.add(
        observation
            .latitude(49.447273149114366)
            .longitude(1.0924529935376541)
            .orientation(15)
            .celestialBody(bodies.get(0))
            .author(users.get(1))
            .description("Une sacrée vue sur Mars !"));
    observations.add(
        observation
            .latitude(49.43851868471619)
            .longitude(1.110829923383208)
            .orientation(78)
            .celestialBody(bodies.get(1))
            .author(users.get(5))
            .description("Mercure, c'est beau"));
    observations.add(
        observation
            .latitude(49.386955811932225)
            .longitude(1.0693351828124036)
            .orientation(44)
            .celestialBody(bodies.get(3))
            .author(users.get(3))
            .description("Le Soleil vu en cours"));
    observations.add(
        observation
            .latitude(49.29345564180719)
            .longitude(1.0042352782499628)
            .orientation(160)
            .celestialBody(bodies.get(2))
            .author(users.get(4)));
    return args -> {
      userRepository.saveAll(users);
      celestialBodyRepository.saveAll(bodies);
      observationRepository.saveAll(observations);
    };
  }
}
