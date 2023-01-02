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
            .setLatitude(49.441750062818144)
            .setLongitude(1.090743186110451)
            .setOrientation(0)
            .setCelestialBody(bodies.get(3))
            .setAuthor(users.get(0)));
    observation = new ObservationEntity();
    observations.add(
        observation
            .setLatitude(49.43089503379546)
            .setLongitude(1.0839555895177384)
            .setOrientation(90)
            .setCelestialBody(bodies.get(2))
            .setAuthor(users.get(2))
            .setDescription("Whaou j'ai vu Neptune"));
    observation = new ObservationEntity();
    observations.add(
        observation
            .setLatitude(49.447273149114366)
            .setLongitude(1.0924529935376541)
            .setOrientation(15)
            .setCelestialBody(bodies.get(0))
            .setAuthor(users.get(1))
            .setDescription("Une sacrée vue sur Mars !"));
    observation = new ObservationEntity();
    observations.add(
        observation
            .setLatitude(49.43851868471619)
            .setLongitude(1.110829923383208)
            .setOrientation(78)
            .setCelestialBody(bodies.get(1))
            .setAuthor(users.get(5))
            .setDescription("Mercure, c'est beau"));
    observation = new ObservationEntity();
    observations.add(
        observation
            .setLatitude(49.386955811932225)
            .setLongitude(1.0693351828124036)
            .setOrientation(44)
            .setCelestialBody(bodies.get(3))
            .setAuthor(users.get(3))
            .setDescription("Le Soleil vu en cours"));
    observation = new ObservationEntity();
    observations.add(
        observation
            .setLatitude(49.29345564180719)
            .setLongitude(1.0042352782499628)
            .setOrientation(160)
            .setCelestialBody(bodies.get(2))
            .setAuthor(users.get(4)));
    return args -> {
      userRepository.saveAll(users);
      celestialBodyRepository.saveAll(bodies);
      observationRepository.saveAll(observations);
    };
  }
}
