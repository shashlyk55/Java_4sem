package org.example.lab09_project;

import java.io.*;
import java.sql.Time;
import java.util.Date;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name="DateTimeServlet", value = "/DateTimeServlet")
public class DateTimeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException{

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println("Привет");
        /*
        * Date currentDateTime = new Date();
        out.println("<h1>DateTime: " + currentDateTime + "</h1>");
        * */
    }

    /*
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        response.getWriter().print("This is " + this.getClass().getName() + ", using the POST method");
    }
*/

    public void destroy(ServletRequest req, ServletResponse res)throws ServletException, IOException {
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    }
}