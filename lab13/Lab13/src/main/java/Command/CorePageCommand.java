package Command;

import com.google.protobuf.ServiceException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CorePageCommand implements Command{
        @Override
        public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
            System.out.println("Core page");
            return new CommandResult("core",false);
        }
}
