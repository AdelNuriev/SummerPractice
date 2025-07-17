package itis.summer.practice.user.repositories.impl.file;

import java.io.*;
import itis.summer.practice.user.entities.User;
import itis.summer.practice.user.repositories.UserRepository;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserRepositoryFile implements UserRepository {
    private final String filename;

    public UserRepositoryFile(String filename) { this.filename = filename; }

    @Override
    public void save(User user) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {

            String uuid = UUID.randomUUID().toString();

            user.setUuid(uuid);

            writer.write(UserFileUtil.toLine(user));
            writer.newLine();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<User> findAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            return reader.lines().map(UserFileUtil::fromLine).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User user) {
        List<String> lines = null;
        Path path = Paths.get(filename);

        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        lines = lines.stream()
                .map(line -> UserFileUtil.fromLine(line).getUuid().equals(user.getUuid()) ?
                        UserFileUtil.toLine(user) : line)
                .toList();

        try {
            Files.write(path, lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<User> findById(String uuid) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (UserFileUtil.fromLine(line).getUuid().equals(uuid))
                    return Optional.of(UserFileUtil.fromLine(line));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }
}