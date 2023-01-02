package fr.openobservatory.backend.model.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class UserEntity {

    @Id
    private UUID id;

    @Column
    private String username;

    // ---

    public static UserEntity create(String username) {
        var user = new UserEntity();
        user.setId(UUID.randomUUID());
        user.setUsername(username);
        return user;
    }
}
