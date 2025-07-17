package itis.summer.practice.user.console;

import itis.summer.practice.user.dto.UserDto;
import itis.summer.practice.user.services.UserService;
import java.util.List;
import java.util.Scanner;

public class UserConsole implements ReadFromConsole {

    private final Scanner scanner;
    private final UserService userService;

    public UserConsole(UserService userService) {
        this.scanner = new Scanner(System.in);
        this.userService = userService;
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

    public void updatePassword() {

        System.out.println("Пользователи:\n");
        printUsers();

        userService.updatePassword(
                readStringInput(scanner, "Выберете id пользователя для обновления пароля"),
                readStringInput(scanner, "Введите новый пароль"));

        System.out.println("Пароль успешно обновлен");
    }
}

