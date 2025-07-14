package itis.summer.practice.repositories;

import itis.summer.practice.entities.User;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserRepositoryList implements UserRepository {
    private final List<User> users = new ArrayList<>();

    @Override
    public void save(User user) {
        String uuid = UUID.randomUUID().toString();

        user.setUuid(uuid);

        users.add(user);
    }

    @Override
    public List<User> findAll() {
        return users;
    }
}
