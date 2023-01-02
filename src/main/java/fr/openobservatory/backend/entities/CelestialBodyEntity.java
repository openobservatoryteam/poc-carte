package fr.openobservatory.backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
public class CelestialBodyEntity {

  public CelestialBodyEntity() {}

  public CelestialBodyEntity(String name) {
    this.name = name;
  }

  @Id @GeneratedValue private Integer id;

  @Column private String name;
}
