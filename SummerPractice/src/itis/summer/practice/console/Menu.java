package itis.summer.practice.console;

import java.util.Scanner;

public class Menu {

    Scanner scanner;
    UserConsole userConsole;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.userConsole = new UserConsole();
    }

    public void run() {

        while (true) {
            printMenu();

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> userConsole.signUp();
                case 2 -> userConsole.printUsers();
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
        System.out.println("0. Выход");
    }
}
