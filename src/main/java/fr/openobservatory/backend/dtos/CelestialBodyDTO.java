package fr.openobservatory.backend.dtos;

import fr.openobservatory.backend.entities.CelestialBodyEntity;

public record CelestialBodyDTO(Integer id, String name) {

  public static CelestialBodyDTO from(CelestialBodyEntity celestialBody) {
    return new CelestialBodyDTO(celestialBody.getId(), celestialBody.getName());
  }
}
