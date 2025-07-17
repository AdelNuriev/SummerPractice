package itis.summer.practice.user.repositories.impl.file;

import itis.summer.practice.user.entities.User;

public class UserFileUtil {

    public static String toLine(User user) {
        return user.getUuid() + "|" +
                user.getUsername() + "|" +
                user.getPassword();
    }

    public static User fromLine(String line) {
        String[] parts = line.split("\\|");

        return new User(parts[0], parts[1], parts[2]);
    }
}
