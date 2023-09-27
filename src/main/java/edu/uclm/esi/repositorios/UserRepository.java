package edu.uclm.esi.repositorios;

import edu.uclm.esi.entities.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {
    private Map<UUID, User> users = new HashMap<>();

    public void add(User user) {
        users.put(user.getId(), user);
    }

    public Optional<User> get(UUID uuid) {
        return Optional.ofNullable(users.get(uuid));
    }

    public List<User> getAll() {
        return null;
    }
}
