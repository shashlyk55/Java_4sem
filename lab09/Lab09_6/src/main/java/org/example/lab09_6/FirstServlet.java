package org.example.lab09_6;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

@WebServlet("/start")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String name = "get";
        request.setAttribute("name","get");
        request.getRequestDispatcher("second").forward(request, response);        //response.sendRedirect("Servlet2?name=" + name);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
            request.setAttribute("name","post");
            request.getRequestDispatcher("second").forward(request, response);
        }
    }

