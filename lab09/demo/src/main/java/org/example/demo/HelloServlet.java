package org.example.demo;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");

        java.io.PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}