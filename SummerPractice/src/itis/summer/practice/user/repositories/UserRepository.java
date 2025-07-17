package itis.summer.practice.user.repositories;

import itis.summer.practice.user.entities.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository {

    public void save(User user);

    public List<User> findAll();

    void update(User user);

    Optional<User> findById(String uuid);
}
