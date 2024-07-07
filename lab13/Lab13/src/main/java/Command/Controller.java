package Command;

import com.google.protobuf.ServiceException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Controller", value = "/Controller")
public class Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request,response);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request,response);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException {
        String command = request.getParameter("COMMAND");
        Command action = CommandFactory.create(command);
        CommandResult commandResult;
        commandResult = action.execute(request, response);

        String page = commandResult.getPage();
        getServletContext().getRequestDispatcher("/" + page + ".jsp").forward(request, response);
    }
}
