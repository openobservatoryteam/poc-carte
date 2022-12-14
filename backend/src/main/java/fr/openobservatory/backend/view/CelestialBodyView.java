package fr.openobservatory.backend.view;

import fr.openobservatory.backend.model.celestial_body.CelestialBodyEntity;

import java.util.UUID;

public record CelestialBodyView(UUID id,
                                String name) {

    public static CelestialBodyView from(CelestialBodyEntity celestialBody) {
        return new CelestialBodyView(celestialBody.getId(), celestialBody.getName());
    }
}
