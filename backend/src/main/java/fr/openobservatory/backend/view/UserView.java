package fr.openobservatory.backend.view;

import fr.openobservatory.backend.model.user.UserEntity;

import java.util.UUID;

public record UserView(UUID id,
                       String username) {

    public static UserView from(UserEntity user) {
        return new UserView(user.getId(), user.getUsername());
    }
}
