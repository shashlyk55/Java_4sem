package org.example.mvc_app.controller;

import org.example.mvc_app.model.service.UserService;

public class CommandFactory {
    public static ICommand createCommand(String commandName, UserService userService) {
        switch (commandName) {
            case "login":
                return new LoginCommand(userService);
            case "register":
                return new RegisterCommand(userService);
            case "logout":
                return new LogoutCommand();
            default:
                throw new IllegalArgumentException("Invalid command: " + commandName);
        }
    }
}
