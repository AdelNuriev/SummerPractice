package itis.summer.practice.repositories;

import java.io.*;
import itis.summer.practice.entities.User;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryFile implements UserRepository {

    private final String filename;

    public UserRepositoryFile(String filename) { this.filename = filename; }

    @Override
    public void save(User user) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {

            writer.write(
                    user.getUuid() + "|" +
                            user.getUsername() + "|" +
                            user.getPassword()
            );

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<User> findAll() {

        List<User> users = new ArrayList<>();

        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            while((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                users.add(new User(
                        parts[0],
                        parts[1],
                        parts[2]
                ));

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return users;
    }
}

