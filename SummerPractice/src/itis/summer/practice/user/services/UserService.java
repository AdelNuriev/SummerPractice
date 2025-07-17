package itis.summer.practice.user.services;

import itis.summer.practice.user.dto.UserDto;
import itis.summer.practice.user.entities.User;
import itis.summer.practice.user.repositories.UserRepository;
import java.util.List;

public class UserService {

    private final int MIN_PASSWORD_LENGTH = 7;
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void signUp(String username, String password) {

        validatePassword(password);

        User user = new User(username, password);

        userRepository.save(user);
    }

    public List<UserDto> getUsers() {
        return userRepository.findAll().stream()
                .map(user -> new UserDto(user.getUuid(), user.getUsername()))
                .toList();
    }

    private void validatePassword(String password) {
        if (password.length() < MIN_PASSWORD_LENGTH) {
            throw new IllegalArgumentException("Пароль меньше 7 символов");
        }
    }

    public void updatePassword(String uuid, String newPassword) {
        User user = userRepository.
                findById(uuid).
                orElseThrow(() -> new IllegalArgumentException("Пользователь не найден"));

        user.setPassword(newPassword);

        userRepository.update(user);
    }
}