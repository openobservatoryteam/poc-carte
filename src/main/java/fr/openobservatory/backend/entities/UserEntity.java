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
public class UserEntity {

  public UserEntity() {}

  public UserEntity(String username) {
    this.username = username;
  }

  @Id @GeneratedValue private Integer id;

  @Column private String username;
}
