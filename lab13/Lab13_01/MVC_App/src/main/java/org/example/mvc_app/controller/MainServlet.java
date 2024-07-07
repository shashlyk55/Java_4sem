package org.example.mvc_app.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.mvc_app.model.dao.UserRepository;
import org.example.mvc_app.model.service.UserService;

import java.io.IOException;

@WebServlet(name = "MainServlet", urlPatterns = {"/main"})
public class MainServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() {
        userService = new UserService(new UserRepository());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException {
        String commandName = request.getParameter("command");
        ICommand command = CommandFactory.createCommand(commandName, userService);
        command.execute(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
