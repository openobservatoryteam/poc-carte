package fr.openobservatory.backend.dtos;

import fr.openobservatory.backend.entities.UserEntity;

public record UserDTO(int id, String username) {

  public static UserDTO from(UserEntity user) {
    return new UserDTO(user.getId(), user.getUsername());
  }
}
