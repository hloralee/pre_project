package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();

        userService.saveUser("Tom", "Hardi", (byte) 35);
        userService.saveUser("Edward", "Bill", (byte) 27);
        userService.saveUser("Spider", "Man", (byte) 18);
        userService.saveUser("Eddi", "Brok", (byte) 39);

        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
