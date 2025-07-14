package itis.summer.practice.console;

import itis.summer.practice.dto.UserDto;
import itis.summer.practice.services.UserService;
import java.util.List;
import java.util.Scanner;

public class UserConsole {

    private final Scanner scanner;
    private final UserService userService;

    public UserConsole() {
        this.scanner = new Scanner(System.in);
        this.userService = new UserService();
    }

    public void signUp() {
        System.out.println("Введите данные пользователя для регистрации:");
        String username = scanner.nextLine();
        String password = scanner.nextLine();

        userService.signUp(username, password);
    }

    public void printUsers() {
        List<UserDto> users = userService.getUsers();

        for (UserDto user : users) {
            System.out.println(user.getUuid() + "|" + user.getUsername());
        }
    }
}

