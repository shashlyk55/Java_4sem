package org.example.mvc_app.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.mvc_app.model.entity.User;
import org.example.mvc_app.model.service.UserService;

import java.io.IOException;

public class RegisterCommand implements ICommand {
    private final UserService userService;

    public RegisterCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        if (userService.register(user)) {
            response.sendRedirect("login.jsp?success=Registration successful");
        } else {
            response.sendRedirect("register.jsp?error=Username already exists");
        }
    }
}
