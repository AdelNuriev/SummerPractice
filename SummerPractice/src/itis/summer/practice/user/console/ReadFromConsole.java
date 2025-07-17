package itis.summer.practice.user.console;

import java.util.Scanner;

public interface ReadFromConsole {
    default int readIntInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt + " ");
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число.");
            }
        }
    }

    default double readFloatInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt + " ");
                return Float.parseFloat(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите число.");
            }
        }
    }

    default String readStringInput(Scanner scanner, String prompt) {
        System.out.print(prompt + " ");
        return scanner.nextLine().trim();
    }
}
