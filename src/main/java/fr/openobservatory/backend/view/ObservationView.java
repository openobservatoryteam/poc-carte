package fr.openobservatory.backend.view;

import fr.openobservatory.backend.model.observation.ObservationEntity;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

public record ObservationView(UUID id,
                              String description,
                              ObservatoryLocationView location,
                              Integer orientation,
                              CelestialBodyView celestialBody,
                              UserView author,
                              OffsetDateTime createdAt
) {

    public static ObservationView from(ObservationEntity observation) {
        return new ObservationView(
                observation.getId(),
                observation.getDescription(),
                new ObservatoryLocationView(observation.getLatitude(), observation.getLongitude()),
                observation.getOrientation(),
                CelestialBodyView.from(observation.getCelestialBody()),
                UserView.from(observation.getAuthor()),
                observation.getCreatedAt().atOffset(ZoneOffset.UTC));
    }

    private record ObservatoryLocationView(Double latitude, Double longitude) {
    }
}
