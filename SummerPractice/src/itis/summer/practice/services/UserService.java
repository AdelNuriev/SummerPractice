package itis.summer.practice.services;

import itis.summer.practice.dto.UserDto;
import itis.summer.practice.entities.User;
import itis.summer.practice.repositories.UserRepositoryList;
import java.util.List;

public class UserService {

    private final int MIN_PASSWORD_LENGTH = 7;
    private final UserRepositoryList userRepositoryList;

    public UserService() {
        this.userRepositoryList = new UserRepositoryList();
    }

    public void signUp(String username, String password) {

        validatePassword(password);

        User user = new User(username, password);

        userRepositoryList.save(user);
    }

    public List<UserDto> getUsers() {
        return userRepositoryList.findAll().stream()
                .map(user -> new UserDto(user.getUuid(), user.getUsername()))
                .toList();
    }

    private void validatePassword(String password) {
        if (password.length() < MIN_PASSWORD_LENGTH) {
            throw new IllegalArgumentException("Пароль меньше 7 символов");
        }
    }
}