package itis.summer.practice.repositories;

import itis.summer.practice.entities.User;
import java.util.List;

public interface UserRepository {

    public void save(User user);

    public List<User> findAll();
}
