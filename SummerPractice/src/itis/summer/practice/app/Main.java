package itis.summer.practice.app;

import itis.summer.practice.console.Menu;
import itis.summer.practice.user.console.UserConsole;
import itis.summer.practice.user.repositories.UserRepository;
import itis.summer.practice.user.repositories.impl.file.UserRepositoryFile;
import itis.summer.practice.user.repositories.impl.list.UserRepositoryList;
import itis.summer.practice.user.services.UserService;

public class Main {
    public static void main(String[] args) {

        UserRepository userRepositoryFile = new UserRepositoryFile("user.txt");
        UserRepository userRepositoryList = new UserRepositoryList();

        UserService userService = new UserService(userRepositoryFile);

        UserConsole userConsole = new UserConsole(userService);

        Menu menu = new Menu(userConsole);
        menu.run();
    }
}