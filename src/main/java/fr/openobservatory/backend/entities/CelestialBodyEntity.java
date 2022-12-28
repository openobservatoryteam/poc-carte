package fr.openobservatory.backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CelestialBodyEntity {

  @Id private Integer id;

  @Column private String name;

  public static CelestialBodyEntity create(String name) {
    var celestialBody = new CelestialBodyEntity();
    celestialBody.setName(name);
    return celestialBody;
  }
}
