package itis.summer.practice.console;

import itis.summer.practice.user.console.UserConsole;

import java.util.Scanner;

public class Menu {

    Scanner scanner;
    UserConsole userConsole;

    public Menu(UserConsole userConsole) {
        this.scanner = new Scanner(System.in);
        this.userConsole = userConsole;
    }

    public void run() {

        while (true) {
            printMenu();

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> userConsole.signUp();
                case 2 -> userConsole.printUsers();
                case 3 -> userConsole.updatePassword();
                case 0 -> System.exit(0);
                default -> {
                    System.out.println("Неверный выбор");
                }
            }
        }
    }

    public void printMenu() {
        System.out.println("Работа с пользователями");
        System.out.println("1. Регистрация");
        System.out.println("2. Просмотреть список пользователей");
        System.out.println("3. Обновить пароль");
        System.out.println("0. Выход");
    }
}
