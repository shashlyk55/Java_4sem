package org.example.lab09_2;

import java.io.*;
import java.util.Collection;
import java.util.Date;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class GetInfoServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        Collection<String> headers = response.getHeaderNames();
        //ArrayList<String> headers = (ArrayList<String>) response.getHeaderNames();
        PrintWriter out = response.getWriter();

        Date currentDate = new Date();
        // Hello
        out.println("<html><body>");
        out.println("<h1>" + currentDate + "</h1>");
        out.println("</body></html>");

        for(String headerName : headers){
            out.println("<h3>Header Name: " + headerName + response.getHeader(headerName) + "</h3>");
            out.println("<h3>Header Info: " + response.getHeader(headerName) + "</h3>");
        }
    }

    public void destroy() {
    }
}