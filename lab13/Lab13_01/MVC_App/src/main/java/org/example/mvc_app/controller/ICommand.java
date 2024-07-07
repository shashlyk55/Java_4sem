package org.example.mvc_app.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface ICommand {
    void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException;
}
