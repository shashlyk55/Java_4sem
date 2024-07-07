package org.example.lab09_3;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.lab09_3.DataBase.DataBaseConnector;

@WebServlet(name = "LogInServlet", value = "/LogInServlet")
public class LogInServlet extends HttpServlet {

    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String login = request.getParameter("name_login");
        String password = request.getParameter("password_login");

        if(IsMatchData(password,login)) {

            /*PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h3>Hello, " + login + "</h3>");
            out.println("</body></html>");*/
            request.setAttribute("userlogin",login);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/HelloUserServlet");
            dispatcher.forward(request,response);

            response.addCookie(new Cookie("username",login));
            response.sendRedirect("HelloPage.jsp");
        }
        else
            response.sendRedirect("RegisterPage.jsp");
            //response.sendRedirect("ErrorPage.jsp");
    }

    public void destroy() {
    }

    private boolean IsMatchData(String hashPassword, String login){
        boolean exists = false;
        String url = "jdbc:mysql://localhost/users_db?useSSL=false";
        String username = "root";
        String password = "123qweasdzxc";
        try {
            DataBaseConnector dbConnector = new DataBaseConnector(url,username,password);
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            dbConnector.OpenConnection();
            exists = dbConnector.IsUserInDB(login,hashPassword);
            dbConnector.CloseConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return exists;
    }
}